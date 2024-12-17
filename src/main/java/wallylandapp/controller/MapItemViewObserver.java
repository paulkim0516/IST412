package wallylandapp.controller;

import wallylandapp.model.MapItem;

public interface MapItemViewObserver {
    void onShowMap();
    void onReserve(MapItem item);
}
