/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

import wallylandapp.model.Schedule;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paulk
 */
public class Reservation {
    private List<Schedule> reservations;

    public Reservation() {
        reservations = new ArrayList<>();
    }

    public void addReservation(String name, String date, String time) {
        reservations.add(new Schedule(name, date, time));
    }

    public List<Schedule> getReservations() {
        return reservations;
    }
}
