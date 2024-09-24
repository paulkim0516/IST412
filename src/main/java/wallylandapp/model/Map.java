/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

import java.util.ArrayList;

/**
 *
 * @author paulk
 */
public class Map {
    private String imageUri;
    private ArrayList<MapItem> mapItems;

    public Map(String imageUri, ArrayList<MapItem> mapItems) {

    }

    /**
     * Get the image URI of the map.
     *
     * @return The image URI of the map.
     */
    public String getImageUri() {
        return imageUri;
    }

    /**
     * Set the image URI of the map.
     *
     * @param imageUri The image URI of the map.
     */
    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    /**
     * Get the map items.
     *
     * @return The map items.
     */
    public ArrayList<MapItem> getMapItems() {
        return mapItems;
    }

    /**
     * Set the map items.
     *
     * @param mapItems The map items.
     */
    public void setMapItems(ArrayList<MapItem> mapItems) {
        this.mapItems = mapItems;
    }

    /**
     * Add a map item to the map.
     *
     * @param mapItem The map item to add.
     */
    public void addMapItem(MapItem mapItem) {

    }

    /**
     * Remove a map item from the map.
     *
     * @param mapItem The map item to remove.
     */
    public void removeMapItem(MapItem mapItem) {

    }
}
