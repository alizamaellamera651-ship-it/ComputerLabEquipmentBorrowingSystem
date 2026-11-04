package com.clebs.repositories;

import java.util.ArrayList;
import com.clebs.models.BorrowingTransaction;

public class BorrowingRepository {


private ArrayList<BorrowingTransaction> transactionList;

// Constructor
public BorrowingRepository() {
    transactionList = new ArrayList<>();
}

// Add transaction
public void addTransaction(BorrowingTransaction transaction) {
    transactionList.add(transaction);
    System.out.println("Borrowing transaction successfully recorded.");
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
