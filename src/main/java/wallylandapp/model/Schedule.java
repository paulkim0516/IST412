/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

/**
 * The Schedule class represents a schedule for a ride at WallyLand.
 * @author paulk
 */
public class Schedule {
    private String name;
    private String date;
    private String time;

    /**
     * Constructs a new Schedule with the specified name, date, and time.
     * @param name
     * @param date
     * @param time
     */
    public Schedule(String name, String date, String time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    /**
     * Returns the name of the schedule.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the date of the schedule.
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the time of the schedule.
     * @return
     */
    public String getTime() {
        return time;
    }
}
