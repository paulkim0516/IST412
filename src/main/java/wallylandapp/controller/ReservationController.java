/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.controller;

import wallylandapp.model.Reservation;
import wallylandapp.view.ReservationView;


/**
 *
 * @author marcusb
 */


public class ReservationController {

    private ReservationView view;
    private Reservation data;
    public ReservationController(Reservation data, ReservationView view) {
        this.view = view;
        this.data = data;

        
    }


    public void initReservation(){

       // view.getReservationArea()
    }


}
