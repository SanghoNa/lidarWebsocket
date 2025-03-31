package com.lidarws;

import javax.websocket.*;
import org.glassfish.tyrus.client.ClientManager;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.lang.reflect.Method;

import processing.core.PApplet;

@ClientEndpoint
public class WebSocketClientMessage {
      private static CountDownLatch latch;
      WebSocketContainer container;
      PApplet parent;
      Session userSession = null;
      private Method webSocketEventProcessing;
      Thread clientThread;
      //DataController dataController;
      boolean isConnect = false;
      String address;

      /*추가부분. 접속 불가시 재접속 시도를 위한 변수 */
      private final int maxRetryCount = 1000;  // 최대 재시도 횟수
      private final int retryInterval = 5000;  // 재시도 간격 (밀리초)
      private int currentRetryCount = 0;
      private ClientManager clientManager; 

      public WebSocketClientMessage(PApplet _parent, String _address) {
            latch = new CountDownLatch(1);
            parent = _parent;
            address = _address;

            try {
        	      webSocketEventProcessing = parent.getClass().getMethod("webSocketEvent", String.class);
            } catch (Exception e) {
                  // no such method, or an error.. which is fine, just ignore
                  System.out.println("no such method");
            }

            clientManager = ClientManager.createClient();
            //URI uri = null;
            
            clientThread = new Thread(() -> {
                  try {
                        URI uri = new URI(_address);
                        
                        //myUri = "ws://localhost:8080/java/demoApp";
                        //container = ContainerProvider.getWebSocketContainer();
                        //container.connectToServer(this, uri);
                        //container.connectToServer(WebSocketClient.class, uri);
                        //clientManager.connectToServer(WebSocketClient.class, uri);
                        //clientManager.getProperties().put("org.glassfish.tyrus.incomingBufferSize", 17000000);
                        clientManager.connectToServer(this, uri);
                        latch.await();
                  }catch (DeploymentException e) { 
                        //e.printStackTrace();
                        handleReconnect(_address);
                  
                  }catch (Exception e) {
                        //throw new RuntimeException(e);
                        //e.printStackTrace();
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
      public void onMessage (String message, Session session) {
            //System.out.println("onMessage's ===> " );
            try {
                  
                  webSocketEventProcessing.invoke(parent, message);
                  
            } catch (Exception e) {
                  System.err.println("Disabling webSocketEvent() because of an error.");
                  e.printStackTrace();
                  webSocketEventProcessing = null;
            }
      }

      @OnClose
      public void onClose (Session session, CloseReason closeReason) {
            System.out.println("[CLIENT]: Session " + session.getId() + " close, because " + closeReason);
            latch.countDown();
            this.userSession = null;
            isConnect = false;
            //dataController = null;

            // 연결이 종료된 후 자동으로 재연결을 시도합니다.
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
            //dataController = null;
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
                        this.userSession.getBasicRemote().sendText(message);
                        
                  } catch (IOException e) {
                        e.printStackTrace();
                  }
		}
      }

}
