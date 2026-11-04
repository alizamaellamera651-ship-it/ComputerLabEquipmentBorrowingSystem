package com.clebs.repositories;

import java.util.ArrayList;
import com.clebs.models.User;

public class UserRepository {


private ArrayList<User> userList;

// Constructor
public UserRepository() {
    userList = new ArrayList<>();
}

// Add user
public void addUser(User user) {
    userList.add(user);
    System.out.println("User successfully registered.");
}

// Get all users
public ArrayList<User> getAllUsers() {
    return userList;
}

// Find user by username
public User findUserByUsername(String username) {

    for (User user : userList) {

        if (user.getUsername().equalsIgnoreCase(username)) {
            return user;
        }
    }

    return null;
}

// Authenticate user
public User authenticate(String username, String password) {

    for (User user : userList) {

        if (user.getUsername().equalsIgnoreCase(username)
                && user.getPassword().equals(password)) {

            return user;
        }
    }

    return null;
}


}
