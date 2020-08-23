/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.gui;

import com.fajar.wsclient.dto.Message;
import com.fajar.wsclient.dto.MessageMapper;
import com.fajar.wsclient.handler.CustomMsgHandler;
import com.fajar.wsclient.process.AppClientEndpoint;
import com.fajar.wsclient.process.StringUtil;
import com.fajar.wsclient.process.ThreadUtil;
import java.awt.Rectangle;
import java.util.Date;
import javax.swing.JCheckBox;

/**
 *
 * @author Republic Of Gamers
 */
public class MainForm extends javax.swing.JFrame {

    private AppClientEndpoint appClientEndpoint;
    private String wsClientId;

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

        btnRegister = new javax.swing.JButton();
        txtInput = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResponse = new javax.swing.JTextArea();
        txtMessageTo = new javax.swing.JTextField();
        btnClearMsg = new javax.swing.JButton();
        btnDIsconnect = new javax.swing.JButton();
        txtWSURL = new javax.swing.JTextField();
        cbSockJS = new javax.swing.JCheckBox();
        btnConnect = new javax.swing.JButton();
        btnSubscribe = new javax.swing.JButton();
        txtSessionId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test WS Client");

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.setEnabled(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtResponse.setColumns(20);
        txtResponse.setRows(5);
        jScrollPane1.setViewportView(txtResponse);

        jScrollPane2.setViewportView(jScrollPane1);

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

        txtWSURL.setText("localhost:8080/dormactivity/realtime-app");
        txtWSURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWSURLActionPerformed(evt);
            }
        });

        cbSockJS.setText("SockJS");
        cbSockJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSockJSActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.setEnabled(false);
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnSubscribe.setText("Subscribe");
        btnSubscribe.setEnabled(false);
        btnSubscribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubscribeActionPerformed(evt);
            }
        });

        txtSessionId.setText("SESSION ID: - ");
        txtSessionId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSessionIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSend))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMessageTo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbSockJS)))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnConnect)
                                    .addComponent(btnSubscribe))))
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSessionId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnRegister)
                                .addGap(18, 18, 18)
                                .addComponent(btnClearMsg)
                                .addGap(18, 18, 18)
                                .addComponent(btnDIsconnect)
                                .addGap(18, 18, 18)
                                .addComponent(txtWSURL, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtSessionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister)
                    .addComponent(btnClearMsg)
                    .addComponent(btnDIsconnect)
                    .addComponent(txtWSURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessageTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSockJS)
                    .addComponent(btnConnect))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend)
                    .addComponent(btnSubscribe))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed

        try {
            register();
            btnRegister.setEnabled(false);
            btnDIsconnect.setEnabled(true);
            btnConnect.setEnabled(true);
            cbSockJS.setEnabled(false);
        } catch (Exception e) {

        }

    }//GEN-LAST:event_btnRegisterActionPerformed

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

        if (null != appClientEndpoint) {
            appClientEndpoint.disconnect();
            btnRegister.setEnabled(true);
        }
    }//GEN-LAST:event_btnDIsconnectActionPerformed

    private void txtWSURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWSURLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWSURLActionPerformed

    private void cbSockJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSockJSActionPerformed
        if (null == appClientEndpoint) {
            return;
        }
//        boolean checked = ((JCheckBox) evt.getSource()).isSelected();
//        appClientEndpoint.withSockJS(checked);
    }//GEN-LAST:event_cbSockJSActionPerformed

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        ThreadUtil.run(new Runnable() {
            @Override
            public void run() {
                appClientEndpoint.connect();
                btnSubscribe.setEnabled(true);
            }
        });
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnSubscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscribeActionPerformed
        ThreadUtil.run(new Runnable() {
            @Override
            public void run() {
                appClientEndpoint.subscribe();
                btnSend.setEnabled(true);
            }
        });
    }//GEN-LAST:event_btnSubscribeActionPerformed

    private void txtSessionIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSessionIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSessionIdActionPerformed

    /**
     * Web socket URL ALTERNATIVE
     * ws://localhost:8080/dormactivity/realtime-app/{NUMERIC}/{UNIQUE_ID}/websocket
     * AND ws://localhost:8025/websockets/chat example
     * ws://localhost:8080/dormactivity/realtime-app/12345/EL_FAJR_APP/websocket
     */
    private void register() {
        String wsURL = txtWSURL.getText();

        if (cbSockJS.isSelected()) {
            String sessionId = StringUtil.randomUUID();
            wsURL = wsURL + "/" + StringUtil.randomNumber() + "/" + sessionId + "/websocket";

            appClientEndpoint = new AppClientEndpoint(wsURL,true, sessionId); 

            updateSessionId(sessionId);
        } else {
            appClientEndpoint = new AppClientEndpoint(wsURL);
        }

        appClientEndpoint.setCustomMsgHandler(getMessageHandler());

        System.out.println("connecting to: " + wsURL);
        ThreadUtil.run(appClientEndpoint::start);

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
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSubscribe;
    private javax.swing.JCheckBox cbSockJS;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtMessageTo;
    private javax.swing.JTextArea txtResponse;
    private javax.swing.JTextField txtSessionId;
    private javax.swing.JTextField txtWSURL;
    // End of variables declaration//GEN-END:variables

    private void updateSessionId(Object rawMessage) {
        String extractedId = rawMessage.toString().replace("[ID]", "");
        wsClientId = extractedId;

        txtSessionId.setText("SESSION ID: " + wsClientId);
        txtResponse.setText("Your ID:" + wsClientId);
    }

    /**
     *
     * @param message
     */
    private void showMessage(Message message) {

        String oldText = txtResponse.getText();
        String msgContent = "\n==============================\nFrom: " + message.getMessageFrom();
        msgContent += "\n" + message.getDate();
        msgContent += "\n" + message.getMessage();
        txtResponse.setText(oldText + "\n" + String.valueOf(msgContent) + "\n");
    }

    private boolean isWithSockJs() {
        return appClientEndpoint.isWithSockJs();
    }

    private boolean isSockJsMessageResponse(String raw) {
        return raw.startsWith("a[\"MESSAGE");
    }

    private void showPlainMessage(Object payload) {
        String message = payload.toString();

        if (isWithSockJs() && isSockJsMessageResponse(message)) {
            Message messageObj = MessageMapper.parseSockJsResponse(message);
            showMessage(messageObj);
            return;
        }

        String oldText = txtResponse.getText();
        String msgContent = "---------------------------------------\n";
        msgContent += "PLAIN RESPONSE";
        msgContent += "\n" + message;
        txtResponse.setText(oldText + "\n" + String.valueOf(msgContent) + "\n");
    }

    private void handleMessage(Object payload, AppClientEndpoint client) {
        System.out.println("handleOnMessage:" + payload);

        if (!(payload instanceof Message)) {
            //Recently Connected
            if (payload instanceof String && payload.toString().startsWith("[ID]")) {
                updateSessionId(payload);
            } else {
                showPlainMessage(payload);
            }
            return;
        }

        showMessage((Message) payload);
    }

    private CustomMsgHandler getMessageHandler() {
        return this::handleMessage;
    }

    private void sendMessage() {
        String destination = txtMessageTo.getText();
        String message = txtInput.getText();
        appClientEndpoint.sendMessage(message, destination);
        showUserMessage(message, destination);
        txtInput.setText("");
    }
    
    private void showUserMessage(String rawMessage, String destination){
        Message message = new Message(destination, "You", rawMessage, new Date());
        this.showMessage(message);
    }
}
