/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

import wallylandapp.controller.MainController;

/**
 *
 * @author marcusb
 */
public class Reservation {

    private String event;
    private String userID;
    private int reservationDate;
    private int reservationTime;

    public Reservation(String event, String userID, int reservationDate, int reservationTime ){

        this.userID = userID;
        this.reservationDate = reservationDate;
        this.event = event;
        this.reservationTime = reservationTime;






    }

    public void storeReservation() {

    }

    public void retrieveReservation(){

    }

    public String getCustomerName(){return userID;}


    public String getEvent(){return event;}


    public int getReservationDate(){return reservationDate;}

    //
    public int getReservationTime(){return reservationTime;}

    
}
