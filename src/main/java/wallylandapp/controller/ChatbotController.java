/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDate;

import wallylandapp.model.ChatbotData;
import wallylandapp.view.ChatbotView;

/**
 * The ChatbotController class is responsible for controlling the chatbot functionality.
 * It interacts with the ChatbotData model and the ChatbotView view to manage the chatbot's behavior.
 * @author paulk
 */
public class ChatbotController {
    private ChatbotData data;
    private ChatbotView view;
    private MainController main;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Constructs a ChatbotController object with the specified model and view.
     * @param data the ChatbotData model
     * @param view the ChatbotView view
     * @param mainController the main controller to communicate with
     */
    public ChatbotController(ChatbotData data, ChatbotView view, MainController mainController) {
        this.data = data;
        this.view = view;
        this.main = mainController;

        view.getSendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUserInput();
            }
        });

        initChat();
    }

    /**
     * Handles the user input from the chatbot view.
     */
    private void handleUserInput() {
        String userInput = view.getInputField().getText();
        sendChat(userInput);
        view.getInputField().setText("");
    }

    /**
     * Initializes the chatbot session.
     */
    public void initChat() {

        // Implement the logic after configuring the server.
        /*
        try {
            socket = new Socket("server_address" + "", 12345); // Replace with actual server address and port
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start a new thread to listen for messages from the server
            new Thread(new Runnable() {
                @Override
                public void run() {
                    listen();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    /**
     * Sends a chat message to the chatbot.
     * @param chat the chat message to send
     */
    public void sendChat(String chat) {
        view.getChatArea().append("User: " + chat + "\n");

        // Implement the logic after configuring the server.
        /*
        try {
            out.println(chat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        // For testing purposes, display the chat message in the chat area
        view.getChatArea().append("Server: " + "Response from server" + "\n");
    }

    /**
     * Listens for chat messages from the chatbot server and displays them in the chat area.
     */
    public void listen() {

        // Implement the logic after configuring the server.
        /*
        try {
            String response;
            while ((response = in.readLine()) != null) {
                view.getChatArea().append("Server: " + response + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

    /**
     * Close the chatbot conversation.
     */
    public void close() {
        saveChatLog();
        try {
            if (socket != null) {
                socket.close();
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        data.saveChanges();
        main.showMap();
    }

    /**
     * Saves the chat log to a text file.
     */
    private void saveChatLog() {
        String chatLogFile = "chatlog-" + System.currentTimeMillis();
        try (FileWriter writer = new FileWriter(chatLogFile + ".txt")) {
            writer.write(view.getChatArea().getText());
            data.addChatDataFilename(chatLogFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
