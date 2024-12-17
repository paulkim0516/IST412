/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.view;

import wallylandapp.model.MapItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.net.URL;

/**
 * The ReservationView class represents the view for the reservation interface.
 * @author paulk & marcusb
 */
public class ReservationView extends JPanel{

    private MapItem mapItem;
    private JLabel headingLabel;
    private JLabel timeLabel;
    private JComboBox<String> timeDropdown;
    private JLabel countLabel;
    private JComboBox<Integer> countDropdown;
    private JLabel totalLabel;
    private JLabel computedTotalLabel;
    private JButton submitButton;
    private JLabel itemImageLabel;

    /**
     * Constructs a new ReservationView with the specified map item.
     * @param item the map item to be reserved
     */
    public ReservationView(MapItem item){
        this.mapItem = item;

        // Main panel with BorderLayout
        setLayout(new BorderLayout());


        //heading label
        headingLabel = new JLabel("Reserve for " + mapItem.getName(), SwingConstants.CENTER);
        headingLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        headingLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // time label
        timeLabel = new JLabel("Select Time: ");
        timeLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        timeLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Dropdown for available times
        timeDropdown = new JComboBox<>(new String[]{"10:00 AM", "11:00 AM", "1:00 PM", "2:00 PM", "4:00 PM"});
        timeDropdown.setFont(new Font("Dialog", Font.PLAIN, 16));
        timeDropdown.setBorder(new EmptyBorder(10, 10, 10, 10));
        timeDropdown.setMinimumSize(new Dimension(100, 50));

        // count label
        countLabel = new JLabel("Tickets: ");
        countLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        countLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Dropdown for available ticket counts
        countDropdown = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5});
        countDropdown.addActionListener(e -> calcTotal());
        countDropdown.setFont(new Font("Dialog", Font.PLAIN, 16));
        countDropdown.setBorder(new EmptyBorder(10, 10, 10, 10));
        countDropdown.setMinimumSize(new Dimension(100, 50));

        // Total label
        totalLabel = new JLabel("Total: " );
        totalLabel.setFont(new Font("Dialog", Font.BOLD, 16));
        totalLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Total cost display
        computedTotalLabel = new JLabel("");
        computedTotalLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
        computedTotalLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        //Submit button
        submitButton = new JButton("Submit Reservation");
        submitButton.setFont(new Font("Dialog", Font.BOLD, 24));

        JPanel leftPanel = new JPanel(new GridLayout(3, 2));
        leftPanel.add(timeLabel);
        leftPanel.add(timeDropdown);
        leftPanel.add(countLabel);
        leftPanel.add(countDropdown);
        leftPanel.add(totalLabel);
        leftPanel.add(computedTotalLabel);

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(leftPanel);
        // Load the image
        String imagePath = mapItem.getImageUri();
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon itemImageIcon = new ImageIcon(imageUrl);
            itemImageLabel = new JLabel(itemImageIcon);
        } else {
            itemImageLabel = new JLabel("Image not available");
        }
        centerPanel.add(itemImageLabel);

        add(headingLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);

        resizeImage();
        calcTotal();
    }

    /**
     * Resizes the image to fit the label.
     */
    public void resizeImage() {
        int width = itemImageLabel.getWidth();
        int height = itemImageLabel.getHeight();
        if (width > 0 && height > 0) {
            ImageIcon icon = (ImageIcon) itemImageLabel.getIcon();
            if (icon != null) {
                if (width > height) {
                    Image image = icon.getImage().getScaledInstance(height, height, Image.SCALE_SMOOTH);
                    itemImageLabel.setIcon(new ImageIcon(image));
                } else {
                    Image image = icon.getImage().getScaledInstance(width, width, Image.SCALE_SMOOTH);
                    itemImageLabel.setIcon(new ImageIcon(image));
                }
            }
        }
    }

    /**
     * Calculates the total cost of the reservation.
     */
    public void calcTotal() {
        int ticketCount = (int) countDropdown.getSelectedItem();
        double total = ticketCount * mapItem.getPriceCents() / 100.0;
        computedTotalLabel.setText(String.format("$%.2f", total));
    }

    /**
     * Returns the submit button.
     * @return the submit button
     */
    public JButton getSubmitButton() {
        return submitButton;
    }

    /**
     * Returns the selected time.
     * @return the selected time
     */
    public String getSelectedTime() {
        return timeDropdown.getSelectedItem().toString();
    }

    /**
     * Returns the number of tickets selected.
     * @return the number of tickets selected
     */
    public int getTicketCount() {
        return (int) countDropdown.getSelectedItem();
    }
}