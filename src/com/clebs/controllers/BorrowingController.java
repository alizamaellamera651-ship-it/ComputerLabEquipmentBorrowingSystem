package com.clebs.controllers;

import java.util.ArrayList;

import com.clebs.models.BorrowingTransaction;
import com.clebs.repositories.BorrowingRepository;
import com.clebs.services.BorrowingService;

public class BorrowingController {

    private BorrowingService borrowingService;

    // Constructor
    public BorrowingController() {
        BorrowingRepository borrowingRepository = new BorrowingRepository();
        borrowingService = new BorrowingService(borrowingRepository);
    }

    // Borrow equipment
    public void borrowEquipment(BorrowingTransaction transaction) {
        borrowingService.borrowEquipment(transaction);
    }

    // Return equipment
    public boolean returnEquipment(String transactionId) {
        return borrowingService.returnEquipment(transactionId);
    }

    // View all borrowing transactions
    public ArrayList<BorrowingTransaction> getAllTransactions() {
        return borrowingService.getAllTransactions();
    }

    // Find transaction by ID
    public BorrowingTransaction findTransactionById(String transactionId) {
        return borrowingService.findTransactionById(transactionId);
    }

    // View transactions by student ID
    public ArrayList<BorrowingTransaction> findTransactionsByStudent(String studentId) {
        return borrowingService.findTransactionsByStudent(studentId);
    }
}