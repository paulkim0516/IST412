/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.view;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author paulk & marcusb
 */
public class ChatbotView {
    private JPanel panel;
    private JLabel headingLabel;
    private JTextArea chatArea;
    private JTextField inputArea;
    private JButton sendButton;


    public ChatbotView() {

        // Main panel with BorderLayout
        panel = new JPanel(new BorderLayout());


        //heading label
        headingLabel = new JLabel("WallyLand Chat", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        //chat area in a scrollable pane
        chatArea = new JTextArea();
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);

        // input area and send button
        inputArea = new JTextField(40);
        sendButton = new JButton("Send");

        //action listener to the input field
        inputArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendButton.doClick();
            }
        });

        //action listener to the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = inputArea.getText().trim();
                if (!userInput.isEmpty()) {
                    chatArea.append("You: " + userInput + "\n"); // Display user input in chat area
                    inputArea.setText(""); // Clear the input field
                }
            }
        });

        //panel for the input area and button with FlowLayout
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5)); // Align left, small gaps
        inputPanel.add(inputArea);
        inputPanel.add(sendButton);

        //container for the input panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(Box.createVerticalGlue()); // Add flexible space to push inputPanel up
        bottomPanel.add(inputPanel);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));

        // Add components to the main panel
        panel.add(headingLabel, BorderLayout.NORTH);
        panel.add(chatScrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        /**
        panel = new JPanel(new BorderLayout());
        chatArea = new JTextArea();
        inputArea = new JTextField();
        sendButton = new JButton("Send");
        //exitButton = new JButton("Exit");

        panel.add(chatArea, BorderLayout.CENTER);
        panel.add(inputArea, BorderLayout.SOUTH);
        panel.add(sendButton, BorderLayout.EAST);
     */


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
