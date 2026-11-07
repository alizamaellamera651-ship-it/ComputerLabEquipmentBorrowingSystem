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

    this.transactionId = transactionId;
    this.student = student;
    this.equipment = equipment;
    this.borrowingDate = borrowingDate;
    this.returnDate = returnDate;
    this.status = status;
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
    this.transactionId = transactionId;
}

public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
}

public void setStatus(String status) {
    this.status = status;
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
