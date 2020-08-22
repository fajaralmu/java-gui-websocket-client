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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
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

    private static CountDownLatch latch;
    private Session thisSession;
    private CustomMsgHandler customMsgHandler;
    private final String wsURL;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public AppClientEndpoint(String wsURL) {
        this.wsURL = wsURL;
    }

    public void setCustomMsgHandler(CustomMsgHandler h) {
        this.customMsgHandler = h;
    }

    public String getSessionId() {
        return thisSession.getId();
    }

    @OnOpen
    public void onOpen(Session session) {
        thisSession = session;
        logger.info("Connected ... " + session.getId());

        try {

//            session.getBasicRemote().sendText("start");
        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public static void main(String[] args) {
        String pl = "\"{\\\"messageTo\\\":\\\"Message To \\\",\\\"messageFrom\\\":\\\"0d5e797c-a5ea-490c-89d3-7c02f0ce4315\\\",\\\"message\\\":\\\"dfffd\\\",\\\"date\\\":1598093720651}\"";
        pl = pl.substring(1);
        pl = pl.substring(0, pl.length() - 1);
        System.out.println("PAYLOAD:" + pl);
    }

    static String normalize(String payload) {
        payload = payload.substring(1);
        payload = payload.substring(0, payload.length() - 1);
        return payload;
    }

    private String sockJsPayload(String message, String destination) {
        String payload = MessageMapper.constructMessage(thisSession, destination, message);
        try {
            payload = MessageMapper.OBJECT_MAPPER.writeValueAsString(payload);
            payload = normalize(payload);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(AppClientEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("payload: " + payload);
        String sendingTemplate = "[\"MESSAGE\\ndestination:/response/" + destination + "\\ncontent-type:application/json;charset=UTF-8\\nsubscription:sub-0\\nmessage-id:1itomv18-933\\n\\n" + payload + "\\u0000\"]";
        System.out.println("sendingTemplate: " + sendingTemplate);
        return sendingTemplate;
    }

    public void sendMessage(String message, String destination) {
        try {
            String payload = sockJsPayload(message, destination);// MessageMapper.constructMessage(thisSession, destination, message);
            thisSession.getBasicRemote().sendText(payload);
        } catch (Exception ex) {
            Logger.getLogger(AppClientEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("session: " + session.getClass());

        try {

            logger.info("Received ...." + message);
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

        } catch (DeploymentException | URISyntaxException | InterruptedException e) {

            throw new RuntimeException(e);

        }

    }

    public void disconnect() {
        try {
            thisSession.getBasicRemote().sendText("quit");
        } catch (IOException ex) {
            Logger.getLogger(AppClientEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
