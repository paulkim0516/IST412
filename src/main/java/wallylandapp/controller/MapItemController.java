package wallylandapp.controller;

import java.awt.Container;

import wallylandapp.model.MapItem;
import wallylandapp.view.MapItemView;

/**
 * The MapItemController class manages the interactions between the MapItem model and MapItemView.
 */
public class MapItemController implements MapItemViewObserver {
    private MapItem mapItem;
    private MapItemView mapItemView;
    private MainController main;

    /**
     * Constructs a new MapItemController with the specified map item and map item view.
     * @param mapItem the map item to be controlled
     * @param mapItemView the view associated with the map item
     */
    public MapItemController(MapItem mapItem, MapItemView mapItemView, MainController main) {
        this.mapItem = mapItem;
        this.mapItemView = mapItemView;
        this.main = main;
        mapItemView.addObserver(this);
    }

    /**
     * Sets the name of the map item.
     * @param name the name of the map item
     */
    public void setMapItemName(String name) {
        mapItem.setName(name);
    }

    /**
     * Gets the name of the map item.
     * @return the name of the map item
     */
    public String getMapItemName() {
        return mapItem.getName();
    }

    /**
     * Sets the description of the map item.
     * @param description the description of the map item
     */
    public void setMapItemDescription(String description) {
        mapItem.setDescription(description);
    }

    /**
     * Gets the description of the map item.
     * @return the description of the map item
     */
    public String getMapItemDescription() {
        return mapItem.getDescription();
    }

    /**
     * Sets the image URI of the map item.
     * @param imageUri the image URI of the map item
     */
    @Override
    public void onShowMap() {
        main.showMap();
    }

    /**
     * Reserves the map item.
     */
    @Override
    public void onReserve(MapItem item) {
        main.reserveItem(item);
    }

    /**
     * Gets the view of the map item.
     * @return the view of the map item
     */
    public Container getView() {
        return mapItemView;
    }
}
