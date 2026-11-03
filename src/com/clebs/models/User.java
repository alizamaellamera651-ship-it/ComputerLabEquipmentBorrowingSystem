package com.clebs.models;

public abstract class User {

    // Attributes
    private String userId;
    private String fullName;
    private String username;
    private String password;

    // Constructor
    public User(String userId, String fullName, String username, String password) {
        this.userId = userId;
        this.fullName = fullName;
        this.username = username;
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