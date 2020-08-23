package com.fajar.wsclient.dto;

import java.util.Date;

import javax.websocket.Session;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageMapper {

    public final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static Message getMessage(String json) {
        try {
            return OBJECT_MAPPER.readValue(json, Message.class);
        } catch (Exception e) {
            System.out.println("NOT A DTO MSG");

            return null;
        }
    }

    public static String messageAsString(Message msg) {
        try {
            return OBJECT_MAPPER.writeValueAsString(msg);
        } catch (JsonProcessingException e) {
            System.out.println("messageAsString ERROR");
//            e.printStackTrace();
            return "{}";
        }
    }

    public static String constructMessage(Session session, String destination, String msg) {

        Message message = new Message(destination, session.getId(), msg, new Date());
        return messageAsString(message);

    }

}
