package wallylandapp.view;

import javax.swing.*;

/**
 * The MainView class represents the main application view.
 * It provides the main window for the application.
 * @Author paulk
 */
public class MainView {
    private JFrame frame;
    private JMenuBar menuBar;
    private JMenu navigationMenu;
    private JMenuItem mapMenuItem;
    private JMenuItem chatbotMenuItem;
    private JMenuItem scheduleMenuItem;

    /**
     * Constructs a MainView object with the specified frame.
     */
    public MainView() {
        frame = new JFrame("WallyLand");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create the menu bar
        menuBar = new JMenuBar();

        // Create the navigation menu
        navigationMenu = new JMenu("Menu");

        // Create menu items
        mapMenuItem = new JMenuItem("Map");
        chatbotMenuItem = new JMenuItem("Chatbot");
        scheduleMenuItem = new JMenuItem("Schedule");

        // Add menu items to the navigation menu
        navigationMenu.add(mapMenuItem);
        navigationMenu.add(chatbotMenuItem);
        navigationMenu.add(scheduleMenuItem);

        // Add the navigation menu to the menu bar
        menuBar.add(navigationMenu);

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);
    }

    /**
     * Starts the main application view.
     */
    public void start() {
        frame.setVisible(true);
    }

    /**
     * Gets the main frame of the application.
     * @return the main frame
     */
    public JFrame getFrame() {
        return frame;
    }

    /**
     * Gets the map menu item.
     * @return the map menu item
     */
    public JMenuItem getMapMenuItem() {
        return mapMenuItem;
    }

    /**
     * Gets the chatbot menu item.
     * @return the chatbot menu item
     */
    public JMenuItem getChatbotMenuItem() {
        return chatbotMenuItem;
    }

    /**
     * Gets the schedule menu item.
     * @return the schedule menu item
     */
    public JMenuItem getScheduleMenuItem() {
        return scheduleMenuItem;
    }
}