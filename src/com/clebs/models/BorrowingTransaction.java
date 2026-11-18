package com.clebs.models;

import java.time.LocalDate;

public class BorrowingTransaction {

// Attributes
private String transactionId;
private Student student;
private Equipment equipment;
private LocalDate borrowingDate;
private LocalDate returnDate;
private String status;

// Constructor
public BorrowingTransaction(String transactionId, Student student,
                           Equipment equipment, LocalDate borrowingDate,
                           LocalDate returnDate, String status) {

    if (student == null) {
        throw new IllegalArgumentException("Student cannot be empty.");
    }

    if (equipment == null) {
        throw new IllegalArgumentException("Equipment cannot be empty.");
    }

    if (borrowingDate == null) {
        throw new IllegalArgumentException("Borrowing date cannot be empty.");
    }

    if (borrowingDate.isAfter(LocalDate.now())) {
        throw new IllegalArgumentException("Borrowing date cannot be in the future.");
    }

    this.transactionId = transactionId;
    this.student = student;
    this.equipment = equipment;
    this.borrowingDate = borrowingDate;

    if (returnDate != null) {
        setReturnDate(returnDate);

        if (this.returnDate == null) {
            throw new IllegalArgumentException("Invalid return date.");
        }
    }

    setStatus(status);

    if (this.status == null) {
        throw new IllegalArgumentException("Invalid transaction status.");
    }
}

// Getters
public String getTransactionId() {
    return transactionId;
}

public Student getStudent() {
    return student;
}

public Equipment getEquipment() {
    return equipment;
}

public LocalDate getBorrowingDate() {
    return borrowingDate;
}

public LocalDate getReturnDate() {
    return returnDate;
}

public String getStatus() {
    return status;
}

// Setters
public void setTransactionId(String transactionId) {

    if (transactionId == null || transactionId.trim().isEmpty()) {
        throw new IllegalArgumentException("Transaction ID cannot be empty.");
    }

    this.transactionId = transactionId.trim();
}

// Set return date with validation
public void setReturnDate(LocalDate returnDate) {

    if (returnDate == null) {
        System.out.println("Return date cannot be empty.");
        return;
    }

    if (borrowingDate != null && returnDate.isBefore(borrowingDate)) {
        System.out.println("Return date cannot be earlier than borrowing date.");
        return;
    }

    if (returnDate.isAfter(LocalDate.now())) {
        System.out.println("Return date cannot be in the future.");
        return;
    }

    this.returnDate = returnDate;
}

// Set transaction status with validation
public void setStatus(String status) {

    if (status == null || status.trim().isEmpty()) {
        System.out.println("Transaction status cannot be empty.");
        return;
    }

    if (status.equalsIgnoreCase("Borrowed")) {
        this.status = "Borrowed";
    } 
    else if (status.equalsIgnoreCase("Returned")) {
        this.status = "Returned";
    } 
    else {
        System.out.println("Invalid transaction status.");
    }
}

// Display transaction information
public void displayTransactionInfo() {
    System.out.println("\n====================================");
    System.out.println("       BORROWING TRANSACTION");
    System.out.println("====================================");
    System.out.println("Transaction ID: " + transactionId);
    System.out.println("Student: " + student.getFullName());
    System.out.println("Student ID: " + student.getStudentId());
    System.out.println("Equipment: " + equipment.getEquipmentName());
    System.out.println("Borrowing Date: " + borrowingDate);
    System.out.println("Return Date: " + returnDate);
    System.out.println("Status: " + status);
    System.out.println("====================================");
}


}
