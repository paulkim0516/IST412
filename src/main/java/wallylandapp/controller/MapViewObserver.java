package wallylandapp.controller;

import wallylandapp.model.MapItem;

public interface MapViewObserver {
    void onShowInfo(MapItem item);
    void onReserve(MapItem item);
    void onAskForHelp(MapItem item);
}