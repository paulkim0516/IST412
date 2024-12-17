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
    private int id;
    private String name;
    private String description;
    private String imageUri;
    private double latitude;
    private double longitude;
    private int priceCents;
    
    /**
     * Constructs a MapItem object with the specified name, description, latitude, and longitude.
     * 
     * @param name        the name of the map item
     * @param description the description of the map item
     * @param latitude    the latitude of the map item
     * @param longitude   the longitude of the map item
     */
    public MapItem(int id, String name, String description, String imageUri, double latitude, double longitude, int priceCents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUri = imageUri;
        this.latitude = latitude;
        this.longitude = longitude;
        this.priceCents = priceCents;
    }

    /**
     * Returns the ID of the map item.
     * 
     * @return the ID of the map item
     */
    public int getId() {
        return id;
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

    /**
     * Returns the price of the map item in cents.
     * 
     * @return the price of the map item in cents
     */
    public int getPriceCents() {
        return priceCents;
    }

    /**
     * Sets the price of the map item in cents.
     * 
     * @param priceCents the price of the map item in cents
     */
    public void setPriceCents(int priceCents) {
        this.priceCents = priceCents;
    }

    /**
     * Returns the image source of the map item.
     * 
     * @return the image source of the map item
     */
    public String getImageUri() {
        return imageUri;
    }

    /**
     * Sets the image source of the map item.
     * 
     * @param imageUri the image source of the map item
     */
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
