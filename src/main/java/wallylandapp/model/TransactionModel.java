package wallylandapp.model;

public class TransactionModel {
    private double totalAmount;
    private boolean paymentStatus;

    public TransactionModel() {
        totalAmount = 0.0;
        paymentStatus = false;
    }

    public void addItem(double price) {
        totalAmount += price;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void makePayment() {
        paymentStatus = true;
    }

    public boolean isPaymentCompleted() {
        return paymentStatus;
    }
}