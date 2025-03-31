package com.lidarws;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@ServerEndpoint(value = "/")
public class WebSocketServerEndpoint {
    Session userSession = null;
    private static final Set<Session> sessions = new HashSet<>();
    
    @OnOpen
    public void onOpen (Session session) {
        System.out.println("[SERVER]: Handshake successful!!!!! - Connected!!!!! - Session ID: " + session.getId());
        //userSession = session;
        sessions.add(session);
    }
    @OnMessage
        public void onMessage (String message, Session session) {
            if (message.equalsIgnoreCase("terminate")) {
                try {
                    session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Successfully session closed....."));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("[SERVER]: Session " + session.getId() + " server onMessage " + message);
            
            WebSocketServer.getMessage(message);
          //  return message;
        }
    @OnClose
        public void onClose (Session session, CloseReason closeReason) {
            sessions.remove(session);
            System.out.println("[SERVER]: Session " + session.getId() + " closed, because " + closeReason);
        }
     
    public static void sendMessage(String message)
    {
         // 모든 클라이언트에게 메시지를 보내는 메서드
        for (Session session : sessions) {
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
