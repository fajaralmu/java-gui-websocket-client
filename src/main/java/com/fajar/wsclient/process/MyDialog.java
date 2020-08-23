/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.process;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Republic Of Gamers
 */
public class MyDialog {
    
    public static boolean confirm(Component c, String message){
        return JOptionPane.showConfirmDialog(c, message) == 0;
    }

    public static void info(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    
}
