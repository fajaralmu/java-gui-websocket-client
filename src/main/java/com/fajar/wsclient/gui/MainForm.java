/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.gui;

import com.fajar.wsclient.components.ComponentBuilder;
import com.fajar.wsclient.components.ComponentModifier;
import com.fajar.wsclient.components.PanelRequest;
import com.fajar.wsclient.dto.Message;
import com.fajar.wsclient.dto.MessageMapper;
import com.fajar.wsclient.handler.CustomMsgHandler;
import com.fajar.wsclient.process.AppClientEndpoint;
import com.fajar.wsclient.util.StringUtil;
import com.fajar.wsclient.util.ThreadUtil;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
        panelMessages = new javax.swing.JPanel();
        txtMessageTo = new javax.swing.JTextField();
        btnClearMsg = new javax.swing.JButton();
        btnDIsconnect = new javax.swing.JButton();
        txtWSURL = new javax.swing.JTextField();
        cbSockJS = new javax.swing.JCheckBox();
        btnConnect = new javax.swing.JButton();
        btnSubscribe = new javax.swing.JButton();
        txtSessionId = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Test WS Client");

        btnRegister.setBackground(new java.awt.Color(102, 204, 255));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnSend.setBackground(new java.awt.Color(0, 255, 51));
        btnSend.setText("Send");
        btnSend.setEnabled(false);
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        panelMessages.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout panelMessagesLayout = new javax.swing.GroupLayout(panelMessages);
        panelMessages.setLayout(panelMessagesLayout);
        panelMessagesLayout.setHorizontalGroup(
            panelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );
        panelMessagesLayout.setVerticalGroup(
            panelMessagesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelMessages);

        txtMessageTo.setText("Message To ");

        btnClearMsg.setBackground(new java.awt.Color(255, 204, 0));
        btnClearMsg.setForeground(new java.awt.Color(153, 0, 0));
        btnClearMsg.setText("Clear");
        btnClearMsg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearMsgActionPerformed(evt);
            }
        });

        btnDIsconnect.setBackground(new java.awt.Color(255, 51, 0));
        btnDIsconnect.setForeground(new java.awt.Color(255, 255, 255));
        btnDIsconnect.setText("Disconnect");
        btnDIsconnect.setEnabled(false);
        btnDIsconnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDIsconnectActionPerformed(evt);
            }
        });

        txtWSURL.setText("localhost:8080/websocket1/game-app");
        txtWSURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWSURLActionPerformed(evt);
            }
        });

        cbSockJS.setSelected(true);
        cbSockJS.setText("SockJS");
        cbSockJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSockJSActionPerformed(evt);
            }
        });

        btnConnect.setBackground(new java.awt.Color(102, 204, 255));
        btnConnect.setText("Connect");
        btnConnect.setEnabled(false);
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        btnSubscribe.setBackground(new java.awt.Color(102, 204, 255));
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

        jScrollPane3.setViewportView(jEditorPane1);

        jLabel1.setText("Server :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSessionId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(btnRegister)
                                .addGap(18, 18, 18)
                                .addComponent(cbSockJS)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnClearMsg)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDIsconnect))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnSend))
                                        .addComponent(txtMessageTo, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(37, 37, 37)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnConnect)
                                        .addComponent(btnSubscribe)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtWSURL, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(62, Short.MAX_VALUE))))
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
                    .addComponent(cbSockJS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWSURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessageTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        clearMessages();
    }//GEN-LAST:event_btnClearMsgActionPerformed
    
    private void clearMessages() {
        //        txtResponse.setText("");
        panelMessages.removeAll();
        panelMessages.repaint();
    }

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
        ThreadUtil.run(() -> {
            appClientEndpoint.connect();
            btnSubscribe.setEnabled(true);
        });
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnSubscribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubscribeActionPerformed
        ThreadUtil.run(() -> {
            appClientEndpoint.subscribe();
            btnSend.setEnabled(true);
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
            
            appClientEndpoint = new AppClientEndpoint(wsURL, true, sessionId);
            
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
        java.awt.EventQueue.invokeLater(() -> {
            new MainForm().setVisible(true);
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
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelMessages;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtMessageTo;
    private javax.swing.JTextField txtSessionId;
    private javax.swing.JTextField txtWSURL;
    // End of variables declaration//GEN-END:variables

    private void updateSessionId(Object rawMessage) {
        String extractedId = rawMessage.toString().replace("[ID]", "");
        wsClientId = extractedId;
        
        txtSessionId.setText("SESSION ID: " + wsClientId);
        showMessage("Your ID:" + wsClientId);
    }

    /**
     *
     * @param payload
     */
    private void showMessage(Object payload) {
        System.out.println("showMessage payload type: " + payload.getClass());
//        String oldText = txtResponse.getText();
//        String msgContent = "\n==============================\nFrom: " + message.getMessageFrom();
//        msgContent += "\n" + message.getDate();
//        msgContent += "\n" + message.getMessage();
//        txtResponse.setText(oldText + "\n" + String.valueOf(msgContent) + "\n");
        JPanel panel = createMessageComponent(payload);
        panelMessages.add(panel);
        panelMessages.repaint();
    }
    
    private JPanel createMessageComponent(Object payload) {
        
        int messageComponentHeight = 100;
        int messageComponentWidth = 250;
        int yPos = getNextYPos();
        
        PanelRequest request = PanelRequest.autoPanelNonScroll(1, messageComponentWidth, 5, Color.yellow);
        
        Object[] messageComps;
        
        if (payload instanceof Message) {
            Message message = (Message) payload;
            messageComps = new Object[3];
            messageComps[0] = ComponentBuilder.label("From: " + message.getMessageFrom(), SwingConstants.LEFT);
            messageComps[1] = ComponentBuilder.label("Date: " + message.getDate(), SwingConstants.LEFT);
            messageComps[2] = ComponentBuilder.label(message.getMessage(), SwingConstants.LEFT);
        } else {
            messageComps = new Object[]{ComponentBuilder.label(String.valueOf(payload), SwingConstants.LEFT)};
        }
        
        JPanel jpanel = ComponentBuilder.buildPanelV2(request, messageComps);
        jpanel.setLocation(5, yPos);
        return jpanel;
        
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

//        String oldText = txtResponse.getText();
        String msgContent = "PLAIN RESPONSE";
        msgContent += "\n" + message;
        showMessage(msgContent);
//        txtResponse.setText(oldText + "\n" + String.valueOf(msgContent) + "\n");
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
        
        appClientEndpoint.sendMessage(message, destination, (String s) -> {
            showUserMessage(s, destination);
            txtInput.setText("");
        });
        
    }
    
    private void showUserMessage(String rawMessage, String destination) {
        Message message = new Message(destination, "You", rawMessage, new Date());
        this.showMessage(message);
    }
    
    private int getNextYPos() {
        int margin = 5;
        
        int totalHeight = margin;
        Component[] components = panelMessages.getComponents();
        for (Component component : components) {
            totalHeight += component.getHeight() + margin;
        }
        updatePanelMessagesHeight(totalHeight + 300);
        return totalHeight;
    }
    
    private void updatePanelMessagesHeight(int newHeight) {
        System.out.println("updatePanelMessagesHeight: " + newHeight);
        ComponentModifier.changeSizeHeight(panelMessages, newHeight);
        System.out.println("panel message: " + panelMessages.getHeight());

//        component.setPreferredSize(newDimension);
//		component.setSize(newDimension);

        panelMessages.setPreferredSize(new Dimension(panelMessages.getWidth(), panelMessages.getHeight()));
        jScrollPane2.setViewportView(panelMessages);
        jScrollPane2.validate();        
        jScrollPane2.repaint();
        
    }
}
