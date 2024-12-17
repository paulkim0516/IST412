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
 * The ChatbotView class represents the view for the chatbot interface.
 * @author paulk & marcusb
 */
public class ChatbotView extends JPanel{

    private JLabel headingLabel;
    private JTextArea chatArea;
    private JTextField inputArea;
    private JButton sendButton;

    /**
     * Constructs a new ChatbotView with the chat area and input field.
     */
    public ChatbotView() {

        // Set with BorderLayout
        setLayout(new BorderLayout());


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
        add(headingLabel, BorderLayout.NORTH);
        add(chatScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    /**
     * Gets the chat area.
     * @return
     */
    public JTextArea getChatArea() {
        return chatArea;
    }

    /**
     * Gets the input field.
     * @return
     */
    public JTextField getInputField() {
        return inputArea;
    }

    /**
     * Gets the send button.
     * @return
     */
    public JButton getSendButton() {
        return sendButton;
    }
}
