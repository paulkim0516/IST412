/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallylandapp.model.TransactionModel;
import wallylandapp.view.PurchaseView;

/**
 *
 * @author paulk
 */
public class Transaction {
    private TransactionModel transactionModel;
    private PurchaseView PurchaseView;

    public Transaction(TransactionModel transactionModel, PurchaseView PurchaseView) {
        this.transactionModel = transactionModel;
        this.PurchaseView = PurchaseView;

        initController();
    }

    private void initController() {
        PurchaseView.getPayButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePayment();
            }
        });
    }

    public void addItemToTransaction(double price, String itemName) {
        transactionModel.addItem(price);
        PurchaseView.updateTotal(transactionModel.getTotalAmount());
        PurchaseView.addTransactionDetail(itemName + " - $" + String.format("%.2f", price));
    }

    private void handlePayment() {
        transactionModel.makePayment();
        PurchaseView.addTransactionDetail("Payment completed. Thank you!");
    }
}
