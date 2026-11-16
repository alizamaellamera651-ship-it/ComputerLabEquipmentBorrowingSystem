package com.clebs.models;

public abstract class User {

    // Attributes
    private String userId;
    private String fullName;
    private String username;
    private String password;

    // Constructor
public User(String userId, String fullName, String username, String password) {

    if (userId == null || userId.trim().isEmpty()) {
        throw new IllegalArgumentException("User ID cannot be empty.");
    }

    if (fullName == null || fullName.trim().isEmpty()) {
        throw new IllegalArgumentException("Full name cannot be empty.");
    }

    if (username == null || username.trim().isEmpty()) {
        throw new IllegalArgumentException("Username cannot be empty.");
    }

    if (password == null || password.trim().isEmpty()) {
        throw new IllegalArgumentException("Password cannot be empty.");
    }

    this.userId = userId.trim();
    this.fullName = fullName.trim();
    this.username = username.trim();
    this.password = password;
}

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    // Abstract method
    public abstract void displayDashboard();
}