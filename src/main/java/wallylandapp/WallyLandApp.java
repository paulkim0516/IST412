/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package wallylandapp;

import java.time.LocalDate;

import wallylandapp.controller.MainController;
import wallylandapp.model.User;
import wallylandapp.view.MainView;

/**
 * The main class for the WallyLand application.
 */
public class WallyLandApp {

    public static void main(String[] args) {
        // Create a new user for the application. Change the code when you have a login system.
        User user = new User("John Doe", "john@example.com", User.Role.CUSTOMER, LocalDate.of(1990, 1, 1));
        MainView mainView = new MainView();
        MainController mainController = new MainController(user, mainView);
        mainController.startApp();
    }
}
