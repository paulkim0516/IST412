/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

/**
 * Represents a map item with a name, description, latitude, and longitude.
 * @author paulk
 */
public class MapItem {
    private String name;
    private String description;
    private double latitude;
    private double longitude;
    
    /**
     * Constructs a MapItem object with the specified name, description, latitude, and longitude.
     * 
     * @param name        the name of the map item
     * @param description the description of the map item
     * @param latitude    the latitude of the map item
     * @param longitude   the longitude of the map item
     */
    public MapItem(String name, String description, double latitude, double longitude) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns the name of the map item.
     * 
     * @return the name of the map item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the map item.
     * 
     * @param name the name of the map item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the map item.
     * 
     * @return the description of the map item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the map item.
     * 
     * @param description the description of the map item
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the latitude of the map item.
     * 
     * @return the latitude of the map item
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the map item.
     * 
     * @param latitude the latitude of the map item
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Returns the longitude of the map item.
     * 
     * @return the longitude of the map item
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the map item.
     * 
     * @param longitude the longitude of the map item
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
