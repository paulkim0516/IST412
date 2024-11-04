package wallylandapp.controller;

import wallylandapp.model.ChatbotData;
import wallylandapp.model.User;
import wallylandapp.view.ChatbotView;
import wallylandapp.view.MainView;

/**
 * The MainController class is responsible for controlling the main application functionality.
 * It interacts with the User model and the MainView view to manage the application's behavior.
 * It also handles the navigation between different views and controllers.
 * @Author paulk
 */
public class MainController {
    private User user;
    private MainView view;

    /**
     * Constructs a MainController object with the specified user and view.
     * @param user the User model
     * @param view the MainView view
     */
    public MainController(User user, MainView view) {
        this.view = view;
        this.view.start();
        this.user = user;
    }

    /**
     * Shows the chatbot view.
     */
    public void showChatbot() {
        ChatbotData chatbotData = new ChatbotData(user.getUserId());
        ChatbotView chatbotView = new ChatbotView();
        ChatbotController chatbotController = new ChatbotController(chatbotData, chatbotView, this);
        view.getFrame().setContentPane(chatbotView.getPanel());
    }

    /**
     * Tasks to be performed when the application starts.
     */
    public void startApp() {
        showChatbot();
    }

    /**
     * Shows the map view.
     */
    public void showMap() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'showMap'");
    }
}
