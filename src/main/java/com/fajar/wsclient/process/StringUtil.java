/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.process;

import java.util.Random;
import java.util.UUID;

/**
 *
 * @author Republic Of Gamers
 */
public class StringUtil {
    static final Random RANDOM = new Random();
    
    public static String randomNumber(){
        return String.valueOf(RANDOM.nextInt(999)+100);
    }

    public static String randomUUID() {
       return UUID.randomUUID().toString();
    }
    
}
