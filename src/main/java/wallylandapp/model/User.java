/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wallylandapp.model;

import java.time.LocalDate;

/**
 * User class for the WallyLand application.
 * Represents a user with a name, email, role, and date of birth.
 */
public class User {

    /**
     * Enum for the role of the user.
     */
    public enum Role {
        /**
         * Represents WallyLand Admin.
         */
        ADMIN, 

        /**
         * Represents WallyLand Employee.
         */
        EMPLOYEE, 

        /**
         * Represents WallyLand Customer.
         */
        CUSTOMER
    }

    private String userId;
    private String name;
    private String email;
    private Role role;
    private LocalDate dob;

    /**
     * Constructor for User, including admin, employee, and customer.
     * @param name Name of the user
     * @param email Email of the user
     * @param role Role of the user
     * @param dob Date of birth of the user
     */
    public User(String name, String email, Role role, LocalDate dob) {
        this.userId = "U" + System.currentTimeMillis();
        this.name = name;
        this.email = email;
        this.role = role;
        this.dob = dob;
    }
    
    /**
     * Get the user ID.
     * @return The user ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Get the name of the user.
     * @return The name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the user.
     * @param name The name of the user to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the email of the user.
     * @return The email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the user.
     * @param email The email of the user to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the role of the user.
     * @return The role of the user
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set the role of the user.
     * @param role The role of the user to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Get the date of birth of the user.
     * @return The date of birth of the user
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * Set the date of birth of the user.
     * @param dob The date of birth of the user to set
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}
