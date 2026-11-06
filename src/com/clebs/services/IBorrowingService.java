package com.clebs.services;

import java.util.ArrayList;
import com.clebs.models.BorrowingTransaction;

public interface IBorrowingService {

    void borrowEquipment(BorrowingTransaction transaction);

    boolean returnEquipment(String transactionId);

    ArrayList<BorrowingTransaction> getAllTransactions();

    BorrowingTransaction findTransactionById(String transactionId);

    ArrayList<BorrowingTransaction> findTransactionsByStudent(String studentId);
}