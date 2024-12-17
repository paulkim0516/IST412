package wallylandapp.view;

import wallylandapp.controller.MapItemController;
import wallylandapp.controller.MapItemViewObserver;
import wallylandapp.model.MapItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

public class MapItemView extends JPanel {
    private MapItem mapItem;
    private JLabel itemInfoLabel;
    private JTextArea itemDescriptionArea;
    private JLabel itemPriceLabel;
    private JLabel itemImageLabel;
    private JButton returnButton;
    private JButton reserveButton;
    private JSplitPane splitPane;
    private JSplitPane leftPane;
    private List<MapItemViewObserver> observers = new ArrayList<>();

    public MapItemView(MapItem mapItem) {
        this.mapItem = mapItem;
        initializeComponents();
        layoutComponents();
        registerEventHandlers();
    }

    public void addObserver(MapItemController mapItemController) {
        observers.add(mapItemController);
    }

    private void initializeComponents() {
        itemInfoLabel = new JLabel(mapItem.getName());
        itemInfoLabel.setFont(new Font("Dialog", Font.BOLD, 24));
        itemInfoLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        itemDescriptionArea = new JTextArea(mapItem.getDescription());
        itemDescriptionArea.setLineWrap(true);
        itemDescriptionArea.setWrapStyleWord(true);
        itemDescriptionArea.setEditable(false);
        itemDescriptionArea.setFocusable(false);
        itemDescriptionArea.setFont(new Font("Dialog", Font.PLAIN, 16));
        itemDescriptionArea.setBorder(new EmptyBorder(10, 10, 10, 10));
        itemDescriptionArea.setBackground(UIManager.getColor("Panel.background"));

        itemPriceLabel = new JLabel("Price: $" + String.format("%.2f", mapItem.getPriceCents() / 100.0));
        itemPriceLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        itemPriceLabel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String imagePath = mapItem.getImageUri();
        System.out.println("Image path: " + imagePath); // Debugging statement
        URL imageUrl = getClass().getResource(imagePath);
        if (imageUrl != null) {
            ImageIcon itemImageIcon = new ImageIcon(imageUrl);
            itemImageLabel = new JLabel(itemImageIcon);
        } else {
            System.err.println("Error loading image: " + imagePath); // Debugging statement
            itemImageLabel = new JLabel("Image not available");
        }

        itemImageLabel.setPreferredSize(new Dimension(256, 256));
        itemImageLabel.setVisible(true);

        returnButton = new JButton("Return to Map");
        reserveButton = new JButton("Reserve");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel(new BorderLayout());
        infoPanel.add(itemInfoLabel, BorderLayout.NORTH);

        leftPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        leftPane.setTopComponent(new JScrollPane(itemDescriptionArea));
        leftPane.setBottomComponent(itemPriceLabel);
        leftPane.setResizeWeight(0.8);
        leftPane.setEnabled(false);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(leftPane);
        System.out.println("Image label: " + itemImageLabel); // Debugging statement
        splitPane.setRightComponent(itemImageLabel);
        splitPane.setResizeWeight(0.5); // Set the initial split ratio

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(returnButton);
        buttonPanel.add(reserveButton);

        add(infoPanel, BorderLayout.NORTH);
        add(splitPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add a component listener to resize the image when the split pane is resized
        splitPane.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeImage();
            }
        });
    }

    private void resizeImage() {
        int width = splitPane.getRightComponent().getWidth();
        int height = splitPane.getRightComponent().getHeight();
        if (width > 0 && height > 0) {
            ImageIcon icon = (ImageIcon) itemImageLabel.getIcon();
            if (icon != null) {
                if (width > height) {
                    Image image = icon.getImage().getScaledInstance(height, height, Image.SCALE_SMOOTH);
                    itemImageLabel.setIcon(new ImageIcon(image));
                } else {
                    Image image = icon.getImage().getScaledInstance(width, width, Image.SCALE_SMOOTH);
                    itemImageLabel.setIcon(new ImageIcon(image));
                }
            }
        }
    }

    private void registerEventHandlers() {
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (MapItemViewObserver observer : observers) {
                    observer.onShowMap();
                }
            }
        });

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleReservation();
            }
        });
    }

    private void handleReservation() {
        // send to reservation view
    }

    public void setImage(String imageUri) {
        URL imageUrl = getClass().getResource(imageUri);
        if (imageUrl != null) {
            ImageIcon itemImageIcon = new ImageIcon(imageUrl);
            itemImageLabel.setIcon(itemImageIcon);
            resizeImage();
        } else {
            System.err.println("Error loading image: " + imageUri); // Debugging statement
            itemImageLabel.setText("Image not available");
        }
    }
}