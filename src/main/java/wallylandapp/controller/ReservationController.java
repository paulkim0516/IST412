/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.controller;

import wallylandapp.model.Reservation;
import wallylandapp.view.ReservationView;

/**
 * The ReservationController class manages the interactions between the Reservation model and ReservationView.
 * @author marcusb
 */
public class ReservationController {

    private ReservationView view;
    private Reservation data;
    private MainController main;

    /**
     * Constructs a new ReservationController with the specified reservation and reservation view.
     * @param data the reservation to be controlled
     * @param view the view associated with the reservation
     */
    public ReservationController(Reservation data, ReservationView view, MainController main) {
        this.view = view;
        this.data = data;
        this.main = main;

        view.getSubmitButton().addActionListener(e -> {
            data.setTime(view.getSelectedTime());
            data.setTicketCount(view.getTicketCount());

            main.purchaseItem(data);
        });
    }

    /**
     * Gets the view of the reservation
     * @return the view of the reservation
     */
    public ReservationView getView() {
        return view;
    }
}
