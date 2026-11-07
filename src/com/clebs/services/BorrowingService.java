package com.clebs.services;

import java.util.ArrayList;
import java.time.LocalDate;

import com.clebs.models.BorrowingTransaction;
import com.clebs.repositories.BorrowingRepository;

public class BorrowingService implements IBorrowingService {

    private BorrowingRepository borrowingRepository;

    private int transactionCounter = 1;
    // Constructor
    public BorrowingService(BorrowingRepository borrowingRepository) {
        this.borrowingRepository = borrowingRepository;
    }

    // Record a borrowing transaction with automatic Transaction ID
// Record a borrowing transaction with automatic Transaction ID
@Override
public void borrowEquipment(BorrowingTransaction transaction) {

    if (transaction == null
            || transaction.getStudent() == null
            || transaction.getEquipment() == null) {

        System.out.println("Invalid borrowing transaction.");
        return;
    }

    if (!transaction.getEquipment().isAvailable()) {
        System.out.println("Equipment is unavailable.");
        return;
    }

    // Decrease available equipment quantity
    transaction.getEquipment().borrowItem();

    // Generate automatic Transaction ID
    String transactionId =
            String.format("TR-%04d", transactionCounter++);

    transaction.setTransactionId(transactionId);

    // Save transaction
    borrowingRepository.addTransaction(transaction);

    System.out.println("Transaction ID: " + transactionId);
    System.out.println("Borrowing successfully recorded.");
}

    // Record equipment return
    @Override
    public boolean returnEquipment(String transactionId) {

        if (transactionId == null || transactionId.trim().isEmpty()) {
            System.out.println("Transaction ID cannot be empty.");
            return false;
        }

        BorrowingTransaction transaction =
                borrowingRepository.findTransactionById(transactionId);

        if (transaction == null) {
            System.out.println("Transaction not found.");
            return false;
        }

        if ("Returned".equalsIgnoreCase(transaction.getStatus())) {
            System.out.println("Equipment has already been returned.");
            return false;
        }

        transaction.getEquipment().returnItem();

transaction.setReturnDate(LocalDate.now());
transaction.setStatus("Returned");

        System.out.println("Equipment successfully returned.");

        return true;
    }

    // View all transactions
    @Override
    public ArrayList<BorrowingTransaction> getAllTransactions() {
        return borrowingRepository.getAllTransactions();
    }

    // Find transaction by ID
    @Override
    public BorrowingTransaction findTransactionById(String transactionId) {
        return borrowingRepository.findTransactionById(transactionId);
    }

    // Find transactions by student ID
    @Override
    public ArrayList<BorrowingTransaction> findTransactionsByStudent(String studentId) {

        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Student ID cannot be empty.");
            return new ArrayList<>();
        }

        return borrowingRepository.findTransactionsByStudent(studentId);
    }
}