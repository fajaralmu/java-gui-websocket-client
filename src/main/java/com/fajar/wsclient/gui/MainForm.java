/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.gui;

import com.fajar.wsclient.dto.Message;
import com.fajar.wsclient.handler.CustomMsgHandler;
import com.fajar.wsclient.process.AppClientEndpoint;
import com.fajar.wsclient.process.ThreadUtil;

/**
 *
 * @author Republic Of Gamers
 */
public class MainForm extends javax.swing.JFrame {

    private AppClientEndpoint appClientEndpoint;
    private String clientID; 

    /**
     * Creates new form Main
     */
    public MainForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConnect = new javax.swing.JButton();
        txtInput = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResponse = new javax.swing.JTextArea();
        txtSessionId = new javax.swing.JLabel();
        txtMessageTo = new javax.swing.JTextField();
        btnClearMsg = new javax.swing.JButton();
        btnDIsconnect = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test WS Client");

        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtResponse.setColumns(20);
        txtResponse.setRows(5);
        jScrollPane1.setViewportView(txtResponse);

        jScrollPane2.setViewportView(jScrollPane1);

        txtSessionId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtSessionId.setText("SessionID : -");

        txtMessageTo.setText("Message To ");

        btnClearMsg.setText("Clear");
        btnClearMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMsgActionPerformed(evt);
            }
        });

        btnDIsconnect.setText("Disconnect");
        btnDIsconnect.setEnabled(false);
        btnDIsconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDIsconnectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSessionId, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMessageTo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnConnect)
                            .addGap(18, 18, 18)
                            .addComponent(btnClearMsg)
                            .addGap(18, 18, 18)
                            .addComponent(btnDIsconnect))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnSend)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtSessionId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConnect)
                    .addComponent(btnClearMsg)
                    .addComponent(btnDIsconnect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMessageTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed

        try {
            connect();
            btnConnect.setEnabled(false);
            btnDIsconnect.setEnabled(true);
            
        } catch (Exception e) {

        }

    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed

        if (null == appClientEndpoint) {
            return;
        }
        sendMessage();
    }//GEN-LAST:event_btnSendActionPerformed

    

    private void btnClearMsgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearMsgActionPerformed
        txtResponse.setText("");
    }//GEN-LAST:event_btnClearMsgActionPerformed

    private void btnDIsconnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDIsconnectActionPerformed
        
        if(null != appClientEndpoint){
            appClientEndpoint.disconnect();
            btnConnect.setEnabled(true);
        }
    }//GEN-LAST:event_btnDIsconnectActionPerformed

    private void connect() {
        appClientEndpoint = new AppClientEndpoint();
        appClientEndpoint.setCustomMsgHandler(getMessageHandler());
        ThreadUtil.run(new Runnable() {
            @Override
            public void run() {
                appClientEndpoint.start();
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearMsg;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnDIsconnect;
    private javax.swing.JButton btnSend;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtMessageTo;
    private javax.swing.JTextArea txtResponse;
    private javax.swing.JLabel txtSessionId;
    // End of variables declaration//GEN-END:variables

    private void updateSessionId(Object rawMessage) {
        String pureID =  rawMessage.toString().replace("[ID]", "");
        txtSessionId.setText("SESSION ID: " +pureID);
        clientID = pureID;
        txtResponse.setText("Your ID:" + rawMessage);
    }

    private void updateMessage(Object payload) {
        Message message = (Message) payload;

        String oldText = txtResponse.getText();
        String msgContent = "From: " + message.getMessageFrom();
        msgContent += "\n" + message.getDate();
        msgContent += "\n" + message.getMessage();
        txtResponse.setText(oldText + "\n" + String.valueOf(msgContent));
    }

    private void handleMessage(Object payload, AppClientEndpoint client) {
        System.out.println("handleOnMessage:" + payload);

        if (!(payload instanceof Message)) {
            //Recently Connected
            if (payload instanceof String && payload.toString().startsWith("[ID]")) {
                updateSessionId(payload);
            }
            return;
        }
        
        updateMessage(payload);
    }

    private CustomMsgHandler getMessageHandler() {
        return new CustomMsgHandler() {
            @Override
            public void handleOnMessage(Object payload, AppClientEndpoint client) {
                handleMessage(payload, client);
            }
        };
    }
    
    private void sendMessage() {
        String destination = txtMessageTo.getText();
        String message = txtInput.getText();
        appClientEndpoint.sendMessage(message, destination);
        txtInput.setText("");
    }
}
