package wallylandapp.view;

import javax.swing.JFrame;

/**
 * The MainView class represents the main application view.
 * It provides the main window for the application.
 * @Author paulk
 */
public class MainView {
    private JFrame frame;
    
    /**
     * Constructs a MainView object with the specified frame.
     */
    public MainView() {
        frame = new JFrame("WallyLand");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
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
}
