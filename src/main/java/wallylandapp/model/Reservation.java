/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

/**
 * The Reservation class represents a reservation for a ride at WallyLand.
 * @author marcusb
 */
public class Reservation {
    private MapItem item;
    private String time;
    private int ticketCount;

    /**
     * Constructs a new Reservation with the specified item, time, and ticket count.
     * @param item the item to reserve
     * @param time the time of the reservation
     * @param ticketCount the number of tickets to reserve
     */
    public Reservation(MapItem item, String time, int ticketCount) {
        this.item = item;
        this.time = time;
        this.ticketCount = ticketCount;
    }

    /**
     * Returns the item of the reservation.
     * @return
     */
    public MapItem getItem() {
        return item;
    }

    /**
     * Returns the time of the reservation.
     * @return
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * Returns the time of the reservation.
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns the number of tickets in the reservation.
     * @return
     */
    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    /**
     * Returns the number of tickets in the reservation.
     * @return
     */
    public int getTicketCount() {
        return ticketCount;
    }

    /**
     * Returns the details of the reservation.
     * @return
     */
    public String getDetails() {
        return "Ride: " + item.getName() + " | Time: " + time + " | Tickets: " + ticketCount + " | Total: $" + String.format("%.2f", item.getPriceCents() * ticketCount / 100.0);
    }
}