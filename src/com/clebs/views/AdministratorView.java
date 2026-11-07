package com.clebs.views;

import java.util.ArrayList;
import java.util.Scanner;

import com.clebs.controllers.EquipmentController;
import com.clebs.controllers.BorrowingController;
import com.clebs.models.Equipment;
import com.clebs.models.BorrowingTransaction;

public class AdministratorView {

    private Scanner scanner;
    private EquipmentController equipmentController;
    private BorrowingController borrowingController;

    // Constructor
    public AdministratorView(
            EquipmentController equipmentController,
            BorrowingController borrowingController) {

        this.scanner = new Scanner(System.in);
        this.equipmentController = equipmentController;
        this.borrowingController = borrowingController;
    }

    // Display administrator dashboard
    public void displayDashboard() {

        int choice;

        do {
            System.out.println("\n====================================");
            System.out.println("   LABORATORY ADMINISTRATOR DASHBOARD");
            System.out.println("====================================");
            System.out.println("1. View All Equipment");
            System.out.println("2. Add Equipment");
            System.out.println("3. Update Equipment");
            System.out.println("4. Delete Equipment");
            System.out.println("5. View Borrowing Transactions");
            System.out.println("6. Process Equipment Return");
            System.out.println("7. Logout");
            System.out.println("====================================");
            System.out.print("Enter choice: ");

            choice = readChoice();

            switch (choice) {
                case 1:
                    viewAllEquipment();
                    break;

                case 2:
                    addEquipment();
                    break;

                case 3:
                    updateEquipment();
                    break;

                case 4:
                    deleteEquipment();
                    break;

                case 5:
                    viewAllTransactions();
                    break;

                case 6:
                    processReturn();
                    break;

                case 7:
                    System.out.println("\nLogging out...");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 7);
    }

    // View all equipment
    private void viewAllEquipment() {

        ArrayList<Equipment> equipmentList =
                equipmentController.getAllEquipment();

        System.out.println("\n========== EQUIPMENT LIST ==========");

        if (equipmentList.isEmpty()) {
            System.out.println("No equipment records found.");
            return;
        }

        for (Equipment equipment : equipmentList) {
            equipment.displayEquipmentInfo();
        }
    }

    // Add equipment
    private void addEquipment() {

        System.out.println("\n========== ADD EQUIPMENT ==========");

        System.out.print("Equipment ID: ");
        String id = scanner.nextLine();

        System.out.print("Equipment Name: ");
        String name = scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Quantity: ");
        int quantity = readChoice();

        if (quantity < 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        System.out.print("Condition: ");
        String condition = scanner.nextLine();

        Equipment equipment = new Equipment(
                id, name, category, quantity, condition);

        equipmentController.addEquipment(equipment);

        System.out.println("Equipment added successfully.");
    }

    // Update equipment
    private void updateEquipment() {

        System.out.println("\n========== UPDATE EQUIPMENT ==========");

        System.out.print("Enter Equipment ID: ");
        String id = scanner.nextLine();

        Equipment equipment =
                equipmentController.searchEquipment(id);

        if (equipment == null) {
            System.out.println("Equipment not found.");
            return;
        }

        System.out.print("New Equipment Name: ");
        String name = scanner.nextLine();

        System.out.print("New Category: ");
        String category = scanner.nextLine();

        System.out.print("New Quantity: ");
        int quantity = readChoice();

        if (quantity < 0) {
            System.out.println("Invalid quantity.");
            return;
        }

        System.out.print("New Condition: ");
        String condition = scanner.nextLine();

        boolean updated = equipmentController.updateEquipment(
                id, name, category, quantity, condition);

        if (updated) {
            System.out.println("Equipment updated successfully.");
        } else {
            System.out.println("Unable to update equipment.");
        }
    }

    // Delete equipment
    private void deleteEquipment() {

        System.out.println("\n========== DELETE EQUIPMENT ==========");

        System.out.print("Enter Equipment ID: ");
        String id = scanner.nextLine();

        boolean deleted = equipmentController.deleteEquipment(id);

        if (deleted) {
            System.out.println("Equipment deleted successfully.");
        } else {
            System.out.println("Equipment not found.");
        }
    }

    // View all borrowing transactions
    private void viewAllTransactions() {

        ArrayList<BorrowingTransaction> transactions =
                borrowingController.getAllTransactions();

        System.out.println("\n========== BORROWING TRANSACTIONS ==========");

        if (transactions.isEmpty()) {
            System.out.println("No borrowing transactions found.");
            return;
        }

        for (BorrowingTransaction transaction : transactions) {
            transaction.displayTransactionInfo();
        }
    }

    // Process equipment return
    private void processReturn() {

        System.out.println("\n========== PROCESS EQUIPMENT RETURN ==========");

        System.out.print("Enter Transaction ID: ");
        String transactionId = scanner.nextLine();

        boolean returned =
                borrowingController.returnEquipment(transactionId);

        if (!returned) {
            System.out.println("Unable to process return.");
        }
    }

    // Read menu choice
    private int readChoice() {

        try {
            return Integer.parseInt(scanner.nextLine());

        } catch (NumberFormatException e) {
            return -1;
        }
    }
}