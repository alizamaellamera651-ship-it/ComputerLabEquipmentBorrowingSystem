package com.clebs.views;

import javax.swing.*;
import java.awt.*;

import com.clebs.controllers.LoginController;
import com.clebs.models.User;

public class LoginView extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private LoginController loginController;

    public LoginView() {

        loginController = new LoginController();

        setTitle("CLEBS - Login");
        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 40, 25, 40));

        JLabel titleLabel = new JLabel(
                "COMPUTER LABORATORY EQUIPMENT BORROWING SYSTEM",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("LOGIN");

        panel.add(titleLabel);
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);

        add(panel, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);

        loginButton.addActionListener(e -> loginUser());

        passwordField.addActionListener(e -> loginUser());

        setVisible(true);
    }

    private void loginUser() {

        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        User user = loginController.login(username, password);

        if (user != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Welcome, " + user.getFullName() + "!"
            );

            dispose();

            // Dashboard navigation will be connected next.

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid username or password.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}