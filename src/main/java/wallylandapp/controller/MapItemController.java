package wallylandapp.controller;

import wallylandapp.model.MapItem;
import wallylandapp.view.MapItemView;

public class MapItemController implements MapItemViewObserver {
    private MapItem mapItem;
    private MapItemView mapItemView;
    private MainController main;

    public MapItemController(MapItem mapItem, MapItemView mapItemView, MainController main) {
        this.mapItem = mapItem;
        this.mapItemView = mapItemView;
        this.main = main;
        mapItemView.addObserver(this);

        updateView();
    }

    public void updateView() {
        
    }

    public void setMapItemName(String name) {
        mapItem.setName(name);
    }

    public String getMapItemName() {
        return mapItem.getName();
    }

    public void setMapItemDescription(String description) {
        mapItem.setDescription(description);
    }

    public String getMapItemDescription() {
        return mapItem.getDescription();
    }

    @Override
    public void onShowMap() {
        main.showMap();
    }

    @Override
    public void onReserve(MapItem item) {
        main.reserveItem(item);
    }
}
