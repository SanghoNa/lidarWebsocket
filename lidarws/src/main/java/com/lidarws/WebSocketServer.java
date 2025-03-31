package com.lidarws;

import org.glassfish.tyrus.server.Server;

import java.lang.reflect.Method;
import processing.core.PApplet;

public class WebSocketServer {
      
    static PApplet parent;
    Thread serverThread;
    Object serverEndPoint;
    Class<?> eventClass;
    Method sendMessage; 
    private static Method webSocketSVEventProcessing; // get message and send to processing. 
    //Method sendMessage = eventClass.getMethod("sendMessage", String.class);

    public WebSocketServer(PApplet _parent, String _uri, int _port)
    {          
        parent = _parent;
        //serverEndPoint = WebSocketServerEndpoint.class;
        eventClass = WebSocketServerEndpoint.class;
        
        //eventClass = serverEndPoint.getClass();
        //System.out.println(eventClass.getClass().getName());

        try{
                sendMessage = eventClass.getMethod("sendMessage", String.class);
                //System.out.println(sendMessage);
        } catch (Exception e) {
                // no such method, or an error.. which is fine, just ignore
                System.out.println("no such method");
        }

        try {
        	    webSocketSVEventProcessing = parent.getClass().getMethod("webSocketServerEvent", String.class);
        } catch (Exception e) {
                // no such method, or an error.. which is fine, just ignore
                System.out.println("no such method");
        }

        /*
         * server ip. "localHost" is for test in local computer.
         * port number
         * set directory. now set "/lidar". if you want, change target. ex "/myDir"
         */
        Server server = new Server(_uri, _port, "/lidar", null, eventClass);
       //Server server = new Server(_uri, _port, "/lidar", null, WebSocketServerEndpoint.class);

        serverThread = new Thread(() -> {
            try {
                server.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        serverThread.start();
        
        /* 
        try {
            System.out.println("Press enter to stop the server...");
            System.in.read(); // 대기

            server.stop();
            serverThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    public void svSendMessage(String msg)
    {
        try{
            sendMessage.invoke(null, msg);
        } catch (Exception e) {
            System.err.println("Disabling webSocketEvent() because of an error.");
            e.printStackTrace();
            sendMessage = null;
        }
    }

    public static void getMessage(String msg)
    {
        try {
            webSocketSVEventProcessing.invoke(parent, msg);       
        } catch (Exception e) {
                System.err.println("Disabling webSocketEvent() because of an error.");
                e.printStackTrace();
            webSocketSVEventProcessing = null;
        }

    }



}
