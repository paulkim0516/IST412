/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.controller;

import java.util.ArrayList;

import wallylandapp.model.Reservation;
import wallylandapp.view.ScheduleView;

/**
 * The ScheduleController class manages the interactions between the Reservation model and ScheduleView.
 * @author paulk
 */
public class ScheduleController {
    private ArrayList<Reservation> data;
    private ScheduleView view;

    /**
     * Constructs a new ScheduleController with the specified reservations and schedule view.
     * @param reservations the reservations to be controlled
     * @param scheduleView the view associated with the reservations
     * @param mainController the main controller
     */
    public ScheduleController(ArrayList<Reservation> reservations, ScheduleView scheduleView,
            MainController mainController) {

        scheduleView.setReservations(reservations);
        this.data = reservations;
        this.view = scheduleView;        
    }

    /**
     * Gets the view of the schedule
     * @return the view of the schedule
     */
    public ScheduleView getView() {
        return view;
    }
    
}
