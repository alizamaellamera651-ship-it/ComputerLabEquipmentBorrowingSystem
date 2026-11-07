package com.clebs.controllers;

import com.clebs.models.User;
import com.clebs.services.UserService;

public class LoginController {

    private UserService userService;

    // Constructor
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    // Handle user login
    public User login(String username, String password) {

        User user = userService.login(username, password);

        if (user != null) {
            System.out.println("Access granted.");
            return user;
        }

        System.out.println("Access denied.");
        return null;
    }

    // Handle user logout
    public void logout() {
        userService.logout();
    }
}