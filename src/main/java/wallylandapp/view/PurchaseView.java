/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.view;

import javax.swing.*;
import java.awt.*;

public class PurchaseView {
    private JPanel panel;
    private JLabel totalLabel;
    private JButton payButton;
    private JTextArea transactionDetails;

    public PurchaseView() {
        panel = new JPanel(new BorderLayout());

        // Total and payment button
        JPanel topPanel = new JPanel();
        totalLabel = new JLabel("Total: $0.00");
        payButton = new JButton("Pay Now");
        topPanel.add(totalLabel);
        topPanel.add(payButton);

        // Transaction details
        transactionDetails = new JTextArea(10, 30);
        transactionDetails.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionDetails);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getPayButton() {
        return payButton;
    }

    public void updateTotal(double totalAmount) {
        totalLabel.setText("Total: $" + String.format("%.2f", totalAmount));
    }

    public void addTransactionDetail(String detail) {
        transactionDetails.append(detail + "\n");
    }
}
