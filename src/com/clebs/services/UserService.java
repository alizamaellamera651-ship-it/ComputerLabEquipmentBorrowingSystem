package com.clebs.services;

import com.clebs.models.User;
import com.clebs.repositories.UserRepository;

public class UserService {


private UserRepository userRepository;

// Constructor
public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}

// Login / Authenticate user
public User login(String username, String password) {

    if (username == null || username.trim().isEmpty()) {
        System.out.println("Username cannot be empty.");
        return null;
    }

    if (password == null || password.isEmpty()) {
        System.out.println("Password cannot be empty.");
        return null;
    }

    User user = userRepository.authenticate(username, password);

    if (user != null) {
        System.out.println("Login successful. Welcome, "
                + user.getFullName() + "!");
    } else {
        System.out.println("Invalid username or password.");
    }

    return user;
}

// Register user
public void registerUser(User user) {

    if (user == null) {
        System.out.println("Invalid user information.");
        return;
    }

    userRepository.addUser(user);
}

// Logout
public void logout() {
    System.out.println("You have successfully logged out.");
}


}
