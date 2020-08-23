/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.process;

import com.fajar.wsclient.dto.Message;
import com.fajar.wsclient.dto.MessageMapper;
import com.fajar.wsclient.handler.CustomMsgHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.URI;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;

/**
 *
 * @author Republic Of Gamers
 */
@ClientEndpoint
public class AppClientEndpoint {
    //extends Endpoint

    private Session thisSession;
    private CustomMsgHandler customMsgHandler;

    private final String sockJsId;
    private static CountDownLatch latch;
    private final String wsURL;
    private final boolean withSockJS;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public AppClientEndpoint(String wsURL) {
        this.wsURL = wsURL;
        this.sockJsId = null;
        this.withSockJS = false;
    }

    public AppClientEndpoint(String wsURL, boolean withSockJs, String sockJsId) {
        this.wsURL = wsURL;
        this.sockJsId = sockJsId;
        this.withSockJS = withSockJs;
    }

    public void setCustomMsgHandler(CustomMsgHandler h) {
        this.customMsgHandler = h;
    }

    public String getClientId() {
        if (withSockJS) {
            return sockJsId;
        } else {
            return thisSession.getId();
        }
    }

    static String normalize(String payload) {
        payload = payload.substring(1);
        payload = payload.substring(0, payload.length() - 1);
        return payload;
    }

    public void connect() {
        System.out.println("Connecting...");
        String template = "[\"CONNECT\\naccept-version:1.1,1.0\\nheart-beat:10000,10000\\n\\n\\u0000\"]";
        sessionSend(template); 
    }

    /**
     * for SockJS only
     *
     */
    public void subscribe() {
        if (!withSockJS) {
            System.out.println("Not Sock JS");
            MyDialog.info("Subscribe is for SockJS!");
            return;
        }
        System.out.println("Subscribe wsClientId: " + sockJsId);
        String template = "[\"SUBSCRIBE\\nid:sub-" + StringUtil.randomNumber(100, 900) + "\\ndestination:/wsResp/chats/" + sockJsId + "\\n\\n\\u0000\"]";
        sessionSend(template);

    }

    private String sockJsPayload(String message, String destination) {
        String payload = MessageMapper.constructMessage(getClientId(), destination, message);
        try {
            payload = MessageMapper.OBJECT_MAPPER.writeValueAsString(payload);
            payload = normalize(payload);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(AppClientEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("payload: " + payload);
        String sendingTemplate = "[\"MESSAGE\\ndestination:/app/chat\\ncontent-type:application/json;charset=UTF-8\\nsubscription:sub-0\\nmessage-id:1itomv18-933\\n\\n" + payload + "\\u0000\"]";
        System.out.println("sendingTemplate: " + sendingTemplate);
        return sendingTemplate;
    }

    public void sendMessage(String message, String destination) {

        String payload;
        if (withSockJS) {
            payload = sockJsPayload(message, destination);
        } else {
            payload = MessageMapper.constructMessage(getClientId(), destination, message);
        }
        sessionSend(payload);

    }

    private void sessionSend(String text) {
        try {
            thisSession.getBasicRemote().sendText(text);
        } catch (Exception ex) {
            MyDialog.error(ex.getMessage());
            Logger.getLogger(AppClientEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnOpen
    public void onOpen(Session session) {
        thisSession = session;
        logger.info("Connected : " + session.getId());

    }

    @OnError
    public void onError(Session session, Throwable thr) {
        System.out.println("On Error:");
        thr.printStackTrace();
        MyDialog.error(thr.getMessage());
//        super.onError(session, thr); //To change body of generated methods, choose Tools | Templates.
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("Received Message: " + message);

        try {
            Message messagePayload = null;
            try {
                messagePayload = MessageMapper.getMessage(message);
            } catch (Exception e) {

            }
            if (null != customMsgHandler && messagePayload != null) {
                customMsgHandler.handleOnMessage(messagePayload, this);
            } else if (null != customMsgHandler) {
                customMsgHandler.handleOnMessage(message, this);
            }
        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {

        logger.info(String.format("Session %s close because of %s", session.getId(), closeReason));
        latch.countDown();

    }

    public void start() {

        latch = new CountDownLatch(1);
        ClientManager client = ClientManager.createClient();

        try {
            System.out.println("client will connect to server: ws://" + wsURL);
            client.connectToServer(this, new URI("ws://" + wsURL));

            latch.await();

        } catch (Exception e) {
            MyDialog.error(e.getMessage());
            throw new RuntimeException(e);

        }
    }

    public void disconnect() {

        sessionSend("quit");

    }

    public boolean isWithSockJs() {
        return withSockJS;
    }
}
