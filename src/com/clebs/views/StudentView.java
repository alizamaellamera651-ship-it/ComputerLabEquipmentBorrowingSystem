package com.clebs.views;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

import com.clebs.controllers.EquipmentController;
import com.clebs.controllers.BorrowingController;
import com.clebs.models.Student;
import com.clebs.models.Equipment;
import com.clebs.models.BorrowingTransaction;

public class StudentView {

    private Scanner scanner;
    private Student student;
    private EquipmentController equipmentController;
    private BorrowingController borrowingController;

    // Constructor
    public StudentView(Student student,
                       EquipmentController equipmentController,
                       BorrowingController borrowingController) {

        this.scanner = new Scanner(System.in);
        this.student = student;
        this.equipmentController = equipmentController;
        this.borrowingController = borrowingController;
    }

    // Display student dashboard
    public void displayDashboard() {

        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("       STUDENT DASHBOARD");
            System.out.println("====================================");
            System.out.println("Welcome, " + student.getFullName());
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("------------------------------------");
            System.out.println("1. View Available Equipment");
            System.out.println("2. Borrow Equipment");
            System.out.println("3. View Borrowing History");
            System.out.println("4. Return Equipment");
            System.out.println("5. Logout");
            System.out.println("====================================");
            System.out.print("Enter choice: ");

            choice = readChoice();

            switch (choice) {
                case 1:
                    viewAvailableEquipment();
                    break;

                case 2:
                    borrowEquipment();
                    break;

                case 3:
                    viewBorrowingHistory();
                    break;

                case 4:
                    returnEquipment();
                    break;

                case 5:
                    System.out.println("\nLogging out...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 5);
    }

    // View available equipment
    private void viewAvailableEquipment() {

        ArrayList<Equipment> equipmentList =
                equipmentController.getAllEquipment();

        System.out.println("\n========== AVAILABLE EQUIPMENT ==========");

        boolean found = false;

        for (Equipment equipment : equipmentList) {

            if (equipment.isAvailable()) {
                equipment.displayEquipmentInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No equipment is currently available.");
        }
    }

    // Borrow equipment
private void borrowEquipment() {

    viewAvailableEquipment();

    System.out.print("\nEnter Equipment ID: ");
    String equipmentId = scanner.nextLine();

    Equipment equipment =
            equipmentController.searchEquipment(equipmentId);

    if (equipment == null) {
        System.out.println("Equipment not found.");
        return;
    }

    if (!equipment.isAvailable()) {
        System.out.println("Equipment is unavailable.");
        return;
    }

    // Create borrowing transaction
    BorrowingTransaction transaction =
            new BorrowingTransaction(
                    null,
                    student,
                    equipment,
                    LocalDate.now(),
                    null,
                    "Borrowed"
            );

    // Record borrowing transaction
    borrowingController.borrowEquipment(transaction);

    System.out.println("\nBorrowing successful!");
    System.out.println("Your Transaction ID: "
            + transaction.getTransactionId());
}
    // View borrowing history
    private void viewBorrowingHistory() {

        ArrayList<BorrowingTransaction> transactions =
                borrowingController.findTransactionsByStudent(
                        student.getStudentId());

        System.out.println("\n========== BORROWING HISTORY ==========");

        if (transactions.isEmpty()) {
            System.out.println("No borrowing history found.");
            return;
        }

        for (BorrowingTransaction transaction : transactions) {
            transaction.displayTransactionInfo();
        }
    }

    // Return equipment
    private void returnEquipment() {

        System.out.print("\nEnter Transaction ID: ");
        String transactionId = scanner.nextLine();

        boolean returned =
                borrowingController.returnEquipment(transactionId);

        if (!returned) {
            System.out.println("Unable to process equipment return.");
        }
    }

    // Read menu choice safely
    private int readChoice() {

        try {
            int choice = Integer.parseInt(scanner.nextLine());
            return choice;

        } catch (NumberFormatException e) {
            return -1;
        }
    }
}