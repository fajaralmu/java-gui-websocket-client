/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.process;

import com.fajar.wsclient.dto.Message;
import com.fajar.wsclient.dto.MessageMapper;
import com.fajar.wsclient.handler.CustomMsgHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
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

    private Logger logger = Logger.getLogger(this.getClass().getName());

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

            session.getBasicRemote().sendText("start");

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

    public void sendMessage(String message, String destination) {
        try {
            String payload = MessageMapper.constructMessage(thisSession, destination, message);
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

            client.connectToServer(this, new URI("ws://localhost:8025/websockets/test"));

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
