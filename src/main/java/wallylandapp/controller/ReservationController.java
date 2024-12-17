/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import wallylandapp.model.Reservation;
import wallylandapp.view.ReservationView;

/**
 *
 * @author paulk
 */
public class ReservationController {
    private Reservation reservationModel;
    private ReservationView reservationView;

    public ReservationController(Reservation reservationModel, ReservationView reservationView) {
        this.reservationModel = reservationModel;
        this.reservationView = reservationView;

        initController();
    }

    private void initController() {
        reservationView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddReservation();
            }
        });
    }

    private void handleAddReservation() {
        String name = reservationView.getReservationName();
        String date = reservationView.getReservationDate();
        String time = reservationView.getReservationTime();

        reservationModel.addReservation(name, date, time);
        reservationView.displayReservations(reservationModel.getReservations());
    }
}
