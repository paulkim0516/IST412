/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.view;

import wallylandapp.model.Reservation;
import wallylandapp.model.Schedule;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ReservationView {
    private JPanel panel;
    private JTextField nameField;
    private JTextField dateField;
    private JTextField timeField;
    private JButton addButton;
    private JTextArea reservationList;

    public ReservationView() {
        panel = new JPanel(new BorderLayout());

        // Input fields
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Reservation Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        inputPanel.add(new JLabel("Time (HH:MM):"));
        timeField = new JTextField();
        inputPanel.add(timeField);

        addButton = new JButton("Add Reservation");
        inputPanel.add(addButton);

        // Reservation list
        reservationList = new JTextArea(10, 30);
        reservationList.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(reservationList);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public String getReservationName() {
        return nameField.getText();
    }

    public String getReservationDate() {
        return dateField.getText();
    }

    public String getReservationTime() {
        return timeField.getText();
    }
    
    public void displayReservations(List<Schedule> reservations) {
        reservationList.setText("");
        for (Schedule res : reservations) {
            reservationList.append("Name: " + res.getName() + ", Date: " + res.getDate() + ", Time: " + res.getTime() + "\n");
        }
    }
}