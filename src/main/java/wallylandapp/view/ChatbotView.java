/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.view;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author paulk
 */
public class ChatbotView {
    private JPanel panel;
    private JTextArea chatArea;
    private JTextField inputArea;
    private JButton sendButton;

    public ChatbotView() {
        panel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        inputArea = new JTextField();
        sendButton = new JButton("Send");

        panel.add(chatArea, BorderLayout.CENTER);
        panel.add(inputArea, BorderLayout.SOUTH);
        panel.add(sendButton, BorderLayout.EAST);
    }

    public JPanel getPanel() {
        return panel;
    }
    
    public JTextArea getChatArea() {
        return chatArea;
    }

    public JTextField getInputField() {
        return inputArea;
    }

    public JButton getSendButton() {
        return sendButton;
    }
}
