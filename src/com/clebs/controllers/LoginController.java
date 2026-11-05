package com.clebs.controllers;

import com.clebs.models.User;
import com.clebs.repositories.UserRepository;
import com.clebs.services.UserService;

public class LoginController {


private UserService userService;

// Constructor
public LoginController() {
    UserRepository userRepository = new UserRepository();
    userService = new UserService(userRepository);
}

// Handle user login
public User login(String username, String password) {

    User user = userService.login(username, password);

    return user;
}

// Handle logout
public void logout() {
    userService.logout();
}


}
