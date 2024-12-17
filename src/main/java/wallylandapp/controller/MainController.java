package wallylandapp.controller;

import wallylandapp.model.ChatbotData;
import wallylandapp.model.Map;
import wallylandapp.model.MapItem;
import wallylandapp.model.User;
import wallylandapp.view.ChatbotView;
import wallylandapp.view.MainView;
import wallylandapp.view.MapItemView;
import wallylandapp.view.MapView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The MainController class is responsible for controlling the main application functionality.
 * It interacts with the User model and the MainView view to manage the application's behavior.
 * It also handles the navigation between different views and controllers.
 * @Author paulk
 */
public class MainController {
    private User user;
    private MainView view;
    private ChatbotController chatbotController;
    private MapController mapController;
    private MapItemController mapItemController;

    /**
     * Constructs a MainController object with the specified user and view.
     * @param user the User model
     * @param view the MainView view
     */
    public MainController(User user, MainView view) {
        this.view = view;
        this.view.start();
        this.user = user;

        // Initialize Chatbot related data
        ChatbotData chatbotData = new ChatbotData(this.user.getUserId());
        ChatbotView chatbotView = new ChatbotView();
        this.chatbotController = new ChatbotController(chatbotData, chatbotView);

        // Initialize Map related data
        String imageUri = "/resources/map/parkmap.png";
        ArrayList<MapItem> mapItems = new ArrayList<>();

        // Sample data of items on the map
        mapItems.add(new MapItem(
            "Entrance",
            "Welcome to WallyLand—where excitement meets endless fun! As you step through the grand entrance, you'll be greeted by vibrant displays, cheerful staff, and the lively sounds of joy echoing from all corners of the park. Our iconic WallyLand archway makes the perfect spot for your first photo of the day. Stop by the welcome kiosk for maps, schedules, and helpful tips to make the most of your visit!",
            "/resources/rides/entrance.png",
            820,
            650,
            100
        ));

        mapItems.add(new MapItem(
            "Food Court", 
            "Indulge your taste buds at the WallyLand Food Court, where flavors from around the world come together! Whether you're in the mood for gourmet burgers, cheesy pizza, fresh salads, or sweet treats like cotton candy and churros, we've got something for everyone. With plenty of shaded seating and family-friendly options, this is the perfect spot to relax, refuel, and plan your next adventure in the park.", 
            "/resources/rides/foodcourt.png",
            772, 
            440, 
            100
        ));

        mapItems.add(new MapItem(
            "Ferris Wheel", 
            "Take a ride on the magnificent WallyLand Ferris Wheel for a breathtaking view of the entire park! As you ascend to the top, enjoy a serene moment of peace while you overlook the vibrant rides, food courts, and lush landscapes below. Whether it's day or night, the Ferris Wheel promises unforgettable views and picture-perfect memories for visitors of all ages.", 
            "/resources/rides/ferriswheel.png",
            517, 
            1124, 
            100
        ));

        mapItems.add(new MapItem(
            "Carousel", 
            "Experience timeless charm at the WallyLand Carousel! Choose your favorite beautifully hand-painted horse and enjoy a whimsical ride to the sounds of cheerful carnival music. This classic attraction is perfect for families, young children, or anyone looking for a lighthearted and magical experience in the heart of WallyLand.", 
            "/resources/rides/carousel.png",
            743, 
            796, 
            100
        ));

        mapItems.add(new MapItem(
            "Roller Coaster", 
            "Brace yourself for thrills and excitement on the WallyLand Roller Coaster! This high-speed ride is full of sharp twists, exhilarating drops, and heart-pounding turns that will have you screaming with delight. Whether you're an adrenaline junkie or a first-time rider, this attraction guarantees a rush like no other. Hold on tight—it's going to be a wild ride!", 
            "/resources/rides/rollercoaster.png",
            529, 
            162, 
            400
        ));

        mapItems.add(new MapItem(
            "Haunted House", 
            "Dare to enter the chilling WallyLand Haunted House, where shadows lurk and eerie surprises await around every corner. Step into the dimly lit halls and encounter ghostly apparitions, creaking doors, and spine-tingling scares that will leave you on edge. Perfect for thrill-seekers looking for a spooky adventure—enter if you dare, but beware… you may not leave the same way you came in!", 
            "/resources/rides/hauntedhouse.png",
            303, 
            658, 
            300
        ));

        Map map = new Map(imageUri, mapItems);
        MapView mapView = new MapView();
        mapView.setBackgroundImage(imageUri); // Ensure the background image is set
        this.mapController = new MapController(map, mapView, this);
        
        // Add action listeners to the menu items
        view.getMapMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMap();
            }
        });

        view.getChatbotMenuItem().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChatbot();
            }
        });
    }
    
    /**
     * Tasks to be performed when the application starts.
     */
    public void startApp() {
        showMap();
    }

    /**
     * Shows the chatbot view.
     */
    public void showChatbot() {
        view.getFrame().setContentPane(chatbotController.getView().getPanel());
        view.getFrame().revalidate(); // Ensure the frame is updated
        view.getFrame().repaint(); // Ensure the frame is repainted
    }

    /**
     * Shows the map view.
     */
    public void showMap() {
        view.getFrame().setContentPane(mapController.getView().getPanel());
        view.getFrame().revalidate(); // Ensure the frame is updated
        view.getFrame().repaint(); // Ensure the frame is repainted
    }

    public void showMapItemInfo(MapItem item) {
        MapItemView mapItemView = new MapItemView(item);
        this.mapItemController = new MapItemController(item, mapItemView, this);
        mapItemView.setImage(item.getImageUri());
        view.getFrame().setContentPane(mapItemView);
        view.getFrame().revalidate();
        view.getFrame().repaint();
    }

    /**
     * Shows the chatbot view with the context created by the customer.
     * @param item The map item the customer has issue with.
     */
    public void showChatbotWithData(MapItem item) {
        showChatbot();
        chatbotController.requestHelp(item);
    }

    public void reserveItem(MapItem item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reserveItem'");
    }
}