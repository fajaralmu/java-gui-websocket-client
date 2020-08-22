/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.process;

/**
 *
 * @author Republic Of Gamers
 */
public class ThreadUtil {
    
    public static void run(Runnable r){
        Thread thread= new Thread(r);
        thread.start();
    }
    
}
