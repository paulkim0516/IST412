/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * ChatbotData class for the WallyLand application.
 */
public class ChatbotData {

    private String userId;
    private ArrayList<String> chatData;

    /**
     * Constructs a ChatbotData object with the specified user ID.
     * @param userId the user ID
     */
    public ChatbotData(String userId) {
        this.userId = userId;
        chatData = new ArrayList<>();

        File chatLogFile = new File(userId + ".txt");
        if (chatLogFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chatLogFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    chatData.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Adds chat data to the chat log file.
     * @param chatLogFilename the chat log file name to add
     */
    public void addChatDataFilename(String chatLogFilename) {
        chatData.add(chatLogFilename);
    }

    /**
     * Gets the chat data at the specified index.
     * @param index the index of the chat data
     * @return the file name of the chat data at the specified index
     */
    public String getChatDataFilename(int index) {
        return chatData.get(index);
    }

    /**
     * Gets the size of the chat data.
     * @return the size of the chat data
     */
    public int getChatDataSize() {
        return chatData.size();
    }

    /**
     * Saves the changes to the chat log list file.
     */
    public void saveChanges() {
        try (FileWriter writer = new FileWriter(userId + ".txt")) {
            for (String chat : chatData) {
                writer.write(chat + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
