package com.clebs.repositories;

import java.util.ArrayList;
import com.clebs.models.BorrowingTransaction;

public class BorrowingRepository {


private ArrayList<BorrowingTransaction> transactionList;

// Constructor
public BorrowingRepository() {
    transactionList = new ArrayList<>();
}

// Add transaction with validation
public boolean addTransaction(BorrowingTransaction transaction) {

    if (transaction == null) {
        System.out.println("Invalid borrowing transaction.");
        return false;
    }

    if (transaction.getTransactionId() == null ||
            transaction.getTransactionId().trim().isEmpty()) {
        System.out.println("Transaction ID cannot be empty.");
        return false;
    }

    // Check for duplicate transaction ID
    for (BorrowingTransaction existingTransaction : transactionList) {

        if (existingTransaction.getTransactionId()
                .equalsIgnoreCase(transaction.getTransactionId())) {

            System.out.println("Transaction ID already exists.");
            return false;
        }
    }

    transactionList.add(transaction);
    return true;
}

// Get all transactions
public ArrayList<BorrowingTransaction> getAllTransactions() {
    return transactionList;
}

// Find transaction by ID
public BorrowingTransaction findTransactionById(String transactionId) {

    for (BorrowingTransaction transaction : transactionList) {

        if (transaction.getTransactionId().equalsIgnoreCase(transactionId)) {
            return transaction;
        }
    }

    return null;
}

// Find transactions by student ID
public ArrayList<BorrowingTransaction> findTransactionsByStudent(String studentId) {

    ArrayList<BorrowingTransaction> studentTransactions = new ArrayList<>();

    for (BorrowingTransaction transaction : transactionList) {

        if (transaction.getStudent().getStudentId().equalsIgnoreCase(studentId)) {
            studentTransactions.add(transaction);
        }
    }

    return studentTransactions;
}

}
