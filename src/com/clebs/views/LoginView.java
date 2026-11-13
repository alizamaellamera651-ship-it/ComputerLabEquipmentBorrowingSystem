package com.clebs.views;

import java.util.Scanner;

import com.clebs.controllers.LoginController;
import com.clebs.models.User;

public class LoginView {

    private Scanner scanner;
    private LoginController loginController;
    private boolean exitRequested = false;

    // Constructor
    public LoginView(LoginController loginController) {
        this.scanner = new Scanner(System.in);
        this.loginController = loginController;
    }

    // Display login menu
    public User displayLogin() {

        System.out.println("\n==================================");
        System.out.println(" COMPUTER LAB EQUIPMENT BORROWING ");
        System.out.println("             SYSTEM               ");
        System.out.println("==================================");
        System.out.println("[1] Login");
        System.out.println("[2] Exit System");
        System.out.println("==================================");

        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        if (choice.equals("2")) {
            exitRequested = true;
            System.out.println("\nThank you for using CLEBS!");
            System.out.println("System closed.");
            return null;
        }

        if (!choice.equals("1")) {
            System.out.println("\nInvalid choice. Please try again.");
            return null;
        }

        System.out.print("\nUsername: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = loginController.login(username, password);

        if (user != null) {
            System.out.println("\nLogin successful!");
            System.out.println("Welcome, " + user.getFullName() + "!");
        } else {
            System.out.println("\nInvalid username or password.");
        }

        return user;
    }

    // Check if exit was requested
    public boolean isExitRequested() {
        return exitRequested;
    }
}