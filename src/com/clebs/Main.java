package com.clebs;

import com.clebs.models.Student;
import com.clebs.models.LaboratoryAdministrator;
import com.clebs.models.Equipment;
import com.clebs.models.User;

import com.clebs.repositories.UserRepository;
import com.clebs.repositories.EquipmentRepository;
import com.clebs.repositories.BorrowingRepository;

import com.clebs.services.UserService;
import com.clebs.services.EquipmentService;
import com.clebs.services.BorrowingService;

import com.clebs.controllers.LoginController;
import com.clebs.controllers.EquipmentController;
import com.clebs.controllers.BorrowingController;

import com.clebs.views.LoginView;
import com.clebs.views.StudentView;
import com.clebs.views.AdministratorView;

public class Main {

    public static void main(String[] args) {

        // ==================================
        // 1. INITIALIZE REPOSITORIES
        // ==================================

        UserRepository userRepository = new UserRepository();
        EquipmentRepository equipmentRepository =
                new EquipmentRepository();
        BorrowingRepository borrowingRepository =
                new BorrowingRepository();

        // ==================================
        // 2. INITIALIZE SERVICES
        // ==================================

        UserService userService =
                new UserService(userRepository);

        EquipmentService equipmentService =
                new EquipmentService(equipmentRepository);

        BorrowingService borrowingService =
                new BorrowingService(borrowingRepository);

        // ==================================
        // 3. INITIALIZE CONTROLLERS
        // ==================================

        LoginController loginController =
                new LoginController(userService);

        EquipmentController equipmentController =
                new EquipmentController(equipmentService);

        BorrowingController borrowingController =
                new BorrowingController(borrowingService);

        // ==================================
        // 4. REGISTER SAMPLE USERS
        // ==================================

        Student student = new Student(
                "USER-001",
                "Sample Student",
                "student",
                "student123",
                "2026-001",
                "BS Information Technology",
                "1st Year"
        );

        LaboratoryAdministrator administrator =
                new LaboratoryAdministrator(
                        "USER-002",
                        "Sample Administrator",
                        "admin",
                        "admin123",
                        "EMP-001",
                        "Computer Laboratory"
                );

        userService.registerUser(student);
        userService.registerUser(administrator);

        // ==================================
        // 5. ADD SAMPLE EQUIPMENT
        // ==================================

        equipmentController.addEquipment(
                new Equipment(
                        "EQ-001",
                        "Desktop Computer",
                        "Computer",
                        10,
                        "Good"
                )
        );

        equipmentController.addEquipment(
                new Equipment(
                        "EQ-002",
                        "Keyboard",
                        "Peripheral",
                        15,
                        "Good"
                )
        );

        equipmentController.addEquipment(
                new Equipment(
                        "EQ-003",
                        "Mouse",
                        "Peripheral",
                        20,
                        "Good"
                )
        );

        // ==================================
        // 6. INITIALIZE VIEWS
        // ==================================

        LoginView loginView = new LoginView(loginController);

        // ==================================
        // 7. MAIN SYSTEM LOOP
        // ==================================

        boolean running = true;

        while (running) {

            User loggedInUser = loginView.displayLogin();

            if (loggedInUser instanceof Student) {

                StudentView studentView = new StudentView(
                        (Student) loggedInUser,
                        equipmentController,
                        borrowingController
                );

                studentView.displayDashboard();

                loginController.logout();

            } else if (loggedInUser instanceof LaboratoryAdministrator) {

                AdministratorView administratorView =
                        new AdministratorView(
                                equipmentController,
                                borrowingController
                        );

                administratorView.displayDashboard();

                loginController.logout();

            } else {

                System.out.println("\nLogin failed. Please try again.");
            }

        }
    }
}