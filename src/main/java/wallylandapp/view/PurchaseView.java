package wallylandapp.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import wallylandapp.model.Reservation;
import wallylandapp.model.User;

import java.awt.*;

/**
 * The PurchaseView class represents the view for the payment processing interface.
 */
public class PurchaseView extends JPanel {
    private JTextField cardNumberField;
    private JTextField cvvField;
    private JComboBox<String> expMonthDropdown;
    private JComboBox<String> expYearDropdown;
    private JButton payButton;
    private User user;

    /**
     * Constructs a new PurchaseView with the specified reservation and user.
     * @param reservation the reservation to be paid for
     * @param user the user making the reservation
     */
    public PurchaseView(Reservation reservation, User user) {
        setLayout(new BorderLayout());
        this.user = user;

        // Title
        JLabel titleLabel = new JLabel("Payment Processing", JLabel.CENTER);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        add(titleLabel, BorderLayout.NORTH);

        // Input fields for card number and user ID
        JPanel inputPanel = new JPanel(new GridLayout(9, 2, 10, 10));
        inputPanel.setFont(new Font("Dialog", Font.PLAIN, 16));
        inputPanel.setBorder(new EmptyBorder(10, 30, 10, 30));

        // User ID, Ride name, reserved time, ride ticket price, ticket count, total price
        
        inputPanel.add(new JLabel("Ride Name:"));
        inputPanel.add(new JLabel(reservation.getItem().getName()));
        
        inputPanel.add(new JLabel("Reserved Time:"));
        inputPanel.add(new JLabel(reservation.getTime()));
        
        inputPanel.add(new JLabel("Ticket Count:"));
        inputPanel.add(new JLabel(Integer.toString(reservation.getTicketCount())));
        
        inputPanel.add(new JLabel("Ride Ticket Price:"));
        inputPanel.add(new JLabel("$" + String.format("%.2f", reservation.getItem().getPriceCents() / 100.0)));
        
        inputPanel.add(new JLabel("Total Price:"));
        inputPanel.add(new JLabel("$" + String.format("%.2f", reservation.getItem().getPriceCents() * reservation.getTicketCount() / 100.0)));
        
        inputPanel.add(new JLabel("Card Number:"));
        cardNumberField = new JTextField();
        inputPanel.add(cardNumberField);

        inputPanel.add(new JLabel("Cardholder Name:"));
        inputPanel.add(new JLabel(user.getName()));

        inputPanel.add(new JLabel("CVC:"));
        cvvField = new JTextField();
        inputPanel.add(cvvField);
        
        inputPanel.add(new JLabel("Expiration Date:"));
        JPanel expDatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        expMonthDropdown = new JComboBox<>(new String[]{"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"});
        expYearDropdown = new JComboBox<>(new String[]{"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036"});
        expDatePanel.add(expMonthDropdown);
        expDatePanel.add(new JLabel("/"));
        expDatePanel.add(expYearDropdown);
        inputPanel.add(expDatePanel);

        add(inputPanel, BorderLayout.CENTER);

        // Pay button
        payButton = new JButton("Pay Now");
        add(payButton, BorderLayout.SOUTH);
    }

    /**
     * Gets the card number entered by the user.
     * @return
     */
    public String getCardNumber() {
        return cardNumberField.getText();
    }

    /**
     * Gets the CVV entered by the user.
     * @return
     */
    public String getCVV() {
        return cvvField.getText();
    }

    /**
     * Gets the expiration month selected by the user.
     * @return
     */
    public String getExpMonth() {
        return (String) expMonthDropdown.getSelectedItem();
    }

    /**
     * Gets the expiration year selected by the user.
     * @return
     */
    public String getExpYear() {
        return (String) expYearDropdown.getSelectedItem();
    }

    /**
     * Gets the pay button.
     * @return
     */
    public JButton getPayButton() {
        return payButton;
    }

    /**
     * Gets the user ID.
     * @return
     */
    public String getUserId() {
        return user.getUserId();
    }

    /**
     * Shows a message dialog with the specified message.
     * @param string the message to display
     */
    public void showMessageDialog(String string) {
        JOptionPane.showMessageDialog(this, string);
    }
}