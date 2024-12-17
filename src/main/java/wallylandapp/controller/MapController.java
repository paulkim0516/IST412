/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.controller;

import wallylandapp.model.Map;
import wallylandapp.model.MapItem;
import wallylandapp.view.MapView;

/**
 * The MapController class manages the interactions between the Map model and MapView.
 */
public class MapController implements MapViewObserver {
    private Map map;
    private MapView mapView;
    private MainController main;

    /**
     * Constructs a new MapController with the specified map and map view.
     * @param map the map to be controlled
     * @param mapView the view associated with the map
     */
    public MapController(Map map, MapView mapView, MainController main) {
        this.map = map;
        this.mapView = mapView;
        this.main = main;
        mapView.addObserver(this);
        mapView.setBackgroundImage(map.getImageUri());
        updateView();
    }

    /**
     * Updates the map view with the current map items.
     */
    private void updateView() {
        mapView.updateMapView(map.getMapItems());
    }

    /**
     * Adds a map item to the map.
     * @param item the map item to add
     */
    public void addMapItem(MapItem item) {
        map.addMapItem(item);
        updateView();
    }

    /**
     * Removes a map item from the map.
     * @param item the map item to remove
     */
    public void removeMapItem(MapItem item) {
        map.removeMapItem(item);
        updateView();
    }

    /**
     * Gets the view of the map
     * @return the view of the map
     */
    public MapView getView() {
        return mapView;
    }

    @Override
    public void onShowInfo(MapItem item) {
        main.showMapItemInfo(item);
    }

    @Override
    public void onReserve(MapItem item) {
        // Handle reserve action
    }

    @Override
    public void onAskForHelp(MapItem item) {
        main.showChatbotWithData(item);
    }
}
