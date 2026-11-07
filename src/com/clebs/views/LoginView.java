package com.clebs.views;

import java.util.Scanner;

import com.clebs.controllers.LoginController;
import com.clebs.models.User;

public class LoginView {

    private Scanner scanner;
    private LoginController loginController;

    // Constructor
    public LoginView(LoginController loginController) {
        this.scanner = new Scanner(System.in);
        this.loginController = loginController;
    }

    // Display login screen
    public User displayLogin() {

        System.out.println("\n==================================");
        System.out.println(" COMPUTER LAB EQUIPMENT BORROWING ");
        System.out.println("             SYSTEM               ");
        System.out.println("==================================");

        System.out.print("Username: ");
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
}