/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author marcusb
 */
public class ReservationView {

    private JPanel panel;
    private JLabel headingLabel;
    private JTextArea reservationPrompt;

    private JButton submitButton;


    public ReservationView(){

        // Main panel with BorderLayout
        panel = new JPanel(new FlowLayout());


        //heading label
        headingLabel = new JLabel("Make A Reservation", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        //Submit button
        submitButton = new JButton("Submit Reservation");


        //panel for the input area and button with FlowLayout
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 5)); // Align left, small gaps

        inputPanel.add(submitButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                }
        });



        // Add components to the main panel
        panel.add(headingLabel, BorderLayout.NORTH);



    }
}