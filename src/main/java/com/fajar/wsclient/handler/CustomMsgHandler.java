/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.handler;

import com.fajar.wsclient.dto.Message;
import com.fajar.wsclient.process.AppClientEndpoint;

/**
 *
 * @author Republic Of Gamers
 */
public interface CustomMsgHandler {
    
    public void handleOnMessage(Object message, AppClientEndpoint client);
    
}
