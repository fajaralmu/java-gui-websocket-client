package com.fajar.wsclient.dto;

import java.util.Date;


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

    public static String constructMessage(String id, String destination, String msg) {

        Message message = new Message(destination, id, msg, new Date());
        return messageAsString(message);

    }

    static final String EXAMPLE_RAW_MSG = "a[\"MESSAGE\\ndestination:/wsResp/chats/184166bd-1c19-48a0-a195-4cee810c8b66\\ncontent-type:application/json;charset=UTF-8\\nsubscription:sub-0\\nmessage-id:184166bd-1c19-48a0-a195-4cee810c8b66-10\\ncontent-length:145\\n\\n{\\\"messageTo\\\":\\\"184166bd-1c19-48a0-a195-4cee810c8b66\\\",\\\"messageFrom\\\":\\\"afaf410b-7ed5-4f8e-8011-a4fead733fd0\\\",\\\"message\\\":\\\"sdsdsd\\\",\\\"date\\\":1598144649057}\\u0000\"]";

    public static void main(String[] args) throws Exception {
        parseSockJsResponse(EXAMPLE_RAW_MSG);
    }
    //a["MESSAGE\ndestination:/wsResp/chats/184166bd-1c19-48a0-a195-4cee810c8b66\ncontent-type:application/json;charset=UTF-8\nsubscription:sub-0\nmessage-id:184166bd-1c19-48a0-a195-4cee810c8b66-10\ncontent-length:145\n\n{\"messageTo\":\"184166bd-1c19-48a0-a195-4cee810c8b66\",\"messageFrom\":\"afaf410b-7ed5-4f8e-8011-a4fead733fd0\",\"message\":\"sdsdsd\",\"date\":1598144649057}\u0000"]

    public static Message parseSockJsResponse(String rawMessage) {
        Message message = new Message();
        int firstCurlyBraces = rawMessage.indexOf("{");
        rawMessage = rawMessage.substring(firstCurlyBraces, rawMessage.length());
        rawMessage = rawMessage.replace("\\u0000\"]", "");
        rawMessage = rawMessage.replace("\\\"", "\"");
        try {
            message = OBJECT_MAPPER.readValue(rawMessage, Message.class);
        } catch (Exception ex) {
            System.out.println("Error parsing message");
            ex.printStackTrace();
        }

        return message;
    }

}
