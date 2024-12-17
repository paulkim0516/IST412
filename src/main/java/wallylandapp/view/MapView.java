/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import wallylandapp.controller.MapViewObserver;
import wallylandapp.model.MapItem;

/**
 * The MapView class handles the visual representation of the map.
 */
public class MapView extends JPanel{
    private JPanel mapImage;
    private Image image;
    private List<MapItem> mapItems;
    private List<MapViewObserver> observers = new ArrayList<>();

    private final int MARKER_SIZE = 16;
    private final int MARKER_BORDER_SIZE = 3;

    /**
     * Constructs a MapView object.
     * Initializes the panel with a BorderLayout and sets up the map image panel.
     * The map image panel overrides the paintComponent method to draw the map image and markers.
     * Adds a mouse listener to handle map clicks.
     */
    public MapView() {
        setLayout(new BorderLayout());
        mapImage = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    int width = this.getWidth();
                    int height = this.getHeight();
                    g.drawImage(image, 0, 0, width, height, this);

                    // Draw markers
                    if (mapItems != null) {
                        for (MapItem item : mapItems) {
                            int x = (int) (item.getLongitude() * width / image.getWidth(null));
                            int y = (int) (item.getLatitude() * height / image.getHeight(null));
                            
                            // Draw black border
                            g.setColor(Color.BLACK);
                            g.fillOval(
                                x - MARKER_SIZE / 2 - MARKER_BORDER_SIZE, 
                                y - MARKER_SIZE / 2 - MARKER_BORDER_SIZE, 
                                MARKER_SIZE + 2 * MARKER_BORDER_SIZE, 
                                MARKER_SIZE + 2 * MARKER_BORDER_SIZE);
                            
                            // Draw red circle
                            g.setColor(Color.RED);
                            g.fillOval(
                                x - MARKER_SIZE / 2,
                                y - MARKER_SIZE / 2, 
                                MARKER_SIZE, 
                                MARKER_SIZE);
                        }
                    }
                }
            }
        };
        mapImage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMapClick(e.getX(), e.getY());
            }
        });

        add(mapImage, BorderLayout.CENTER);
    }

    /**
     * Adds an observer to the view.
     * @param observer the observer to add
     */
    public void addObserver(MapViewObserver observer) {
        observers.add(observer);
    }

    /**
     * Updates the map view with the given map items.
     * 
     * @param mapItems the list of map items to display
     */
    public void updateMapView(List<MapItem> mapItems) {
        this.mapItems = mapItems;
        mapImage.repaint();
    }

    /**
     * Sets the background image of the map view.
     * 
     * @param imageUri the URI of the image to set as background
     */
    public void setBackgroundImage(String imageUri) {
        this.image = new ImageIcon(getClass().getResource(imageUri)).getImage();
        mapImage.repaint();
    }

    /**
     * Handles a click on the map.
     * 
     * @param x the x-coordinate of the click
     * @param y the y-coordinate of the click
     */
    private void handleMapClick(int x, int y) {
        if (mapItems != null) {
            for (MapItem item : mapItems) {
                int itemX = (int) (item.getLongitude() * mapImage.getWidth() / image.getWidth(null));
                int itemY = (int) (item.getLatitude() * mapImage.getHeight() / image.getHeight(null));
                if (Math.abs(x - itemX) < 10 && Math.abs(y - itemY) < 10) {
                    showMarkerOptions(item, x, y);
                    break;
                }
            }
        }
    }

    /**
     * Shows options for a marker.
     * 
     * @param item the map item
     * @param x    the x-coordinate of the marker
     * @param y    the y-coordinate of the marker
     */
    private void showMarkerOptions(MapItem item, int x, int y) {
        JPopupMenu popupMenu = new JPopupMenu();

        // Create a panel with a title
        JPanel titlePanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel(item.getName());
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titlePanel.add(titleLabel, BorderLayout.CENTER);

        // UI improvements
        titlePanel.setBackground(new Color(0, 0, 128));
        titleLabel.setForeground(Color.LIGHT_GRAY);
        titleLabel.setFont(new Font("Dialog", Font.BOLD, 16));

        // Add the title panel to the popup menu
        popupMenu.add(titlePanel);

        // Create menu items
        JMenuItem option1 = new JMenuItem("Show info");
        JMenuItem option2 = new JMenuItem("Reserve");
        JMenuItem option3 = new JMenuItem("Ask for help");

        option1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyShowInfo(item);
            }
        });

        option2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyReserve(item);
            }
        });

        option3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifyAskForHelp(item);
            }
        });

        // Add menu items to the popup menu
        popupMenu.add(option1);
        popupMenu.add(option2);
        popupMenu.add(option3);

        // Show the popup menu
        popupMenu.show(mapImage, x, y);
    }

    /**
     * Notifies observers about the show info action.
     * @param item the map item
     */
    private void notifyShowInfo(MapItem item) {
        for (MapViewObserver observer : observers) {
            observer.onShowInfo(item);
        }
    }

    /**
     * Notifies observers about the reserve action.
     * @param item the map item
     */
    private void notifyReserve(MapItem item) {
        for (MapViewObserver observer : observers) {
            observer.onReserve(item);
        }
    }

    /**
     * Notifies observers about the ask for help action.
     * @param item the map item
     */
    private void notifyAskForHelp(MapItem item) {
        for (MapViewObserver observer : observers) {
            observer.onAskForHelp(item);
        }
    }
}
