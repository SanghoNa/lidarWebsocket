package com.lidarws;

import javax.websocket.*;
import org.glassfish.tyrus.client.ClientManager;
import java.io.IOException;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import processing.core.PApplet;
import processing.core.PVector;

@ClientEndpoint
public class WebSocketClient {
      private static CountDownLatch latch;
      WebSocketContainer container;
      PApplet parent;
      Session userSession = null;
      Thread clientThread;
      DataController dataController;
      private String dataType = null;
      boolean isConnect = false;
      boolean isNeedData = true;
      String address;

      /*extra add. variables for when cant access to server */
      private final int maxRetryCount = 1000;  // max try cnt.
      private final int retryInterval = 5000;  // try interval
      private int currentRetryCount = 0;
      private ClientManager clientManager; 

      public WebSocketClient(PApplet _parent, String _address, String _dataType) {
            latch = new CountDownLatch(1);
            parent = _parent;
            dataType = _dataType; // object, cloud, scene
            address = _address;
            dataController = new DataController();
            
            clientManager = ClientManager.createClient();
            //URI uri = null;
            
            clientThread = new Thread(() -> {
                  try {
                        URI uri = new URI(_address);
                        
                        clientManager.getProperties().put("org.glassfish.tyrus.incomingBufferSize", 17000000); // set max data buffer size.
                        clientManager.connectToServer(this, uri);
                        latch.await();
                  }catch (DeploymentException e) { 
                        handleReconnect(_address);
                  
                  }catch (Exception e) {
                        handleReconnect(_address);
                  }
                   
            });

            clientThread.start();
      }

      private void handleReconnect(String _address) {
        if (currentRetryCount < maxRetryCount) {
            currentRetryCount++;
            try {
                System.out.println("Connection failed, attempting to reconnect... (Attempt " + currentRetryCount + ")");
                Thread.sleep(retryInterval);
                URI uri = new URI(_address);
                clientManager.getProperties().put("org.glassfish.tyrus.incomingBufferSize", 17000000);
                clientManager.connectToServer(this, uri);
                latch.await();
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
                System.out.println("Reconnection thread interrupted.");
            } catch (Exception e) {
                System.out.println("Failed to reconnect, attempting again...");
                handleReconnect(_address);
            }
        } else {
            System.out.println("Maximum retry attempts reached, giving up.");
        }
      }

      @OnOpen
      public void onOpen (Session session) {
            System.out.println("[CLIENT]: Connection established..... \n[CLIENT]: Session ID: " + session.getId() );
            this.userSession = session;
            isConnect = true;
            currentRetryCount = 0;

      }
      @OnMessage
      public void onMessage (ByteBuffer  message, Session session) {
            try {
                  if(isNeedData)
                  {
                        dataController.dataPars(message, dataType);
                  }     
            } catch (Exception e) {
                  System.err.println("Disabling webSocketEvent() because of an error.");
                  e.printStackTrace();
            }
      }

      @OnClose
      public void onClose (Session session, CloseReason closeReason) {
            System.out.println("[CLIENT]: Session " + session.getId() + " close, because " + closeReason);
            latch.countDown();
            this.userSession = null;
            isConnect = false;

            // after closed session retry connect to server
            if (currentRetryCount < maxRetryCount) {
                  System.out.println("Attempting to reconnect...");
                  handleReconnect(address);  
            } else {
                  System.out.println("Reached maximum retry limit. No further reconnection attempts will be made.");
            }
      }
      @OnError
      public void onError (Session session, Throwable err) {
            System.out.println("[CLIENT]: Error!!!!!, Session ID: " + session.getId() + ", " + err.getMessage());
            isConnect = false;
            this.userSession = null;
            dataController = null;
      }


      /**
	 * 
	 * Sends message to the websocket server
	 * 
	 * @param message The message to send to the server
	 */
      public void sendMessage(String message)
      {
		if (this.userSession != null) {
                  try {
                        System.out.println("onMessageB" );
                        this.userSession.getBasicRemote().sendText(message);
                        
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
		}
      }

      /**
	 * 
	 * set dataType
	 * 
	 * @param type The message to send to the server
	 */
      public void setDataType(String _type)
      {
            System.out.println("[setDataType from client 11111 ==" + _type);
		if (this.userSession != null) {
                  System.out.println("[setDataType from client 22222==" + _type);
                 dataType = _type;
                 sendMessage(dataType);
		}
      }

      /**
	 * 
	 * return peoples position. PVector x, y
	 */
      public ArrayList<PVector> getObjectPos()
      {
           return dataController.getObjectPos();
      }

      /**
	 * 
	 * return peoples velocity. PVector x, y
	 */
      public ArrayList<PVector> getObjectVelocity()
      {
           return dataController.getObjectVelocity();
      }

      /**
	 * 
	 * return size of peoples from Bbox. PVector x, y, z
	 */
      public ArrayList<PVector> getObjectSize()
      {
           return dataController.getObjectSize();
      }

      /**
	 * 
	 * return points of peoples. PVector x, y, z
	 */
      public ArrayList<PVector> getObjectPoints()
      {
           return dataController.getObjectPoints();
      }



      /**
	 * 
	 * return num of peoples. int
	 */
      public int getObjectNum()
      {
           return dataController.getObjectNum();
      }

      /**
	 * 
	 * return Points of evironment. PVector x, y, z
	 */
      public ArrayList<PVector> getCloudPoints()
      {
           return dataController.getCloudPoints();
      }


      /**
       * return connect to server or not.
       */
      public boolean isConnection()
      {
            return isConnect;
      }

      /**
       * return data has or not
       */
      public boolean isPointDataHas()
      {
            return dataController.isPointDataHas();
      }

      public boolean isCloudPointDataHas()
      {
            return dataController.isPointCloudDataHas();
      }


      public void setDataParse(boolean value)
      {
            isNeedData = value;
      }


      public void setArrayReset()
      {
            dataController.setArrayReset();
      }

}
