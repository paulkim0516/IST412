package wallylandapp.controller;

import wallylandapp.model.Reservation;
import wallylandapp.view.PurchaseView;

import java.awt.Component;
import java.util.Calendar;

import javax.swing.JOptionPane;

/**
 * The PurchaseController class manages the interactions between the Reservation model and PurchaseView.
 */
public class PurchaseController {
    private PurchaseView view;
    private Reservation reservation;
    private MainController main;

    /**
     * Constructs a new PurchaseController with the specified reservation and purchase view.
     * @param reservation the reservation to be controlled
     * @param view the view associated with the reservation
     */
    public PurchaseController(Reservation reservation, PurchaseView view, MainController main) {
        this.view = view;
        this.reservation = reservation;
        this.main = main;
        
        view.getPayButton().addActionListener(e -> processPayment());
    }

    /**
     * Processes the payment for the reservation.
     */
    private void processPayment() {
        String cardNumber = view.getCardNumber();
        String cvv = view.getCVV();
        String expMonth = view.getExpMonth();
        String expYear = view.getExpYear();

        // Simple server emulation for transaction
        if (!isValidCardNumber(cardNumber)) {
            view.showMessageDialog("Error: Invalid card number.");
        } else if (!isValidCVV(cvv)) {
            view.showMessageDialog("Error: Invalid CVV.");
        } else if (!isVAlidExpDate(expMonth, expYear)) {
            view.showMessageDialog("Error: Invalid expiration date.");
        } else {
            view.showMessageDialog("Payment successful! Thank you.");
            proceedToScheduleView();
        }
    }

    /**
     * Checks if the card number is valid.
     * @param cardNumber the card number to check
     * @return true if the card number is valid, false otherwise
     */
    private boolean isValidCardNumber(String cardNumber) {
        // Emulate a server check: valid if length == 16 and only digits
        return cardNumber != null && cardNumber.matches("\\d{16}");
    }

    /**
     * Checks if the CVV is valid.
     * @param cvv the CVV to check
     * @return true if the CVV is valid, false otherwise
     */
    private boolean isValidCVV(String cvv) {
        // Emulate a server check: valid if length == 3 and only digits
        return cvv != null && cvv.matches("\\d{3}");
    }

    /**
     * Checks if the expiration date is valid.
     * @param expMonth the expiration month to check
     * @param expYear the expiration year to check
     * @return true if the expiration date is valid, false otherwise
     */
    private boolean isVAlidExpDate(String expMonth, String expYear) {
        // Emulate a server check: valid if month is between 1-12 and year is current year or later
        if (Integer.parseInt(expYear) > Calendar.getInstance().get(Calendar.YEAR)) {
            return true;
        }

        if (Integer.parseInt(expYear) < Calendar.getInstance().get(Calendar.YEAR)) {
            return false;
        }

        return Integer.parseInt(expMonth) > Calendar.getInstance().get(Calendar.MONTH);
    }

    /**
     * Cancels the reservation.
     * @param context the context in which the reservation is cancelled
     * @param reservation the reservation to cancel
     */
    public static void cancelReservation(Component context, Reservation reservation) {
        JOptionPane.showMessageDialog(context, "Reservation cancelled successfully.");
    }
    
    /**
     * Returns the view associated with the controller.
     * @return the view associated with the controller
     */
    public PurchaseView getView() {
        return view;
    }

    /**
     * Proceeds to the schedule view after a successful reservation.
     */
    private void proceedToScheduleView() {
        view.showMessageDialog("Reservation Successful\n" + reservation.getDetails());
        main.addReservation(reservation);
        main.showSchedule();
    }
}