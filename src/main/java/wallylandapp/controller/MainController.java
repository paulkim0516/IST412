package wallylandapp.controller;

import wallylandapp.model.*;
import wallylandapp.view.ChatbotView;
import wallylandapp.view.MainView;
import wallylandapp.view.MapView;
import wallylandapp.view.ReservationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * The MainController class is responsible for controlling the main application functionality.
 * It interacts with the User model and the MainView view to manage the application's behavior.
 * It also handles the navigation between different views and controllers.
 * @Author paulk & marcusb
 */
public class MainController {
    private User user;
    private MainView view;
    private ChatbotController chatbotController;
    private MapController mapController;

    private ReservationController reservationController;
    private Reservation reservation;

    /**
     * Constructs a MainController object with the specified user and view.
     * @param user the User model
     * @param view the MainView view
     */
    public MainController(User user, MainView view) {
        this.view = view;
        this.view.start();
        this.user = user;

        String userID = this.user.getUserId();




        // Initialize Chatbot related data
        ChatbotData chatbotData = new ChatbotData(userID);
        ChatbotView chatbotView = new ChatbotView();
        this.chatbotController = new ChatbotController(chatbotData, chatbotView);


        //Initialize Reservation related data

        ReservationView reservationView = new ReservationView();
        this.reservationController = new ReservationController(reservation, reservationView);




        // Initialize Map related data
        String imageUri = "/wallylandapp/resources/assets/parkmap.png";
        ArrayList<MapItem> mapItems = new ArrayList<>();

        // Sample data of items on the map
        mapItems.add(new MapItem("Entrance", "Entrance of the park", 820, 650));
        mapItems.add(new MapItem("Food Court", "Food court area", 772, 440));
        mapItems.add(new MapItem("Ferris Wheel", "Enjoyable ride for the whole family", 517, 1124));
        mapItems.add(new MapItem("Carousel", "Classic merry-go-round ride", 743, 796));
        mapItems.add(new MapItem("Roller Coaster", "Thrilling roller coaster ride", 529, 162));
        mapItems.add(new MapItem("Haunted House", "Spooky haunted house attraction", 303, 658));

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
     * Shows the chatbot view.
     */
    public void showChatbot() {
        view.getFrame().setContentPane(chatbotController.getView().getPanel());
        view.getFrame().revalidate(); // Ensure the frame is updated
        view.getFrame().repaint(); // Ensure the frame is repainted
    }

    /**
     * Tasks to be performed when the application starts.
     */
    public void startApp() {
        showMap();
    }

    /**
     * Shows the map view.
     */
    public void showMap() {
        view.getFrame().setContentPane(mapController.getView().getPanel());
        view.getFrame().revalidate(); // Ensure the frame is updated
        view.getFrame().repaint(); // Ensure the frame is repainted
    }

    /**
     * Shows the chatbot view with the context created by the customer.
     * @param item The map item the customer has issue with.
     */
    public void showChatbotWithData(MapItem item) {
        showChatbot();
        chatbotController.requestHelp(item);
    }
}