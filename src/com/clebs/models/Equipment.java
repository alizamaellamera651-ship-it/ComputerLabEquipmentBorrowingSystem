package com.clebs.models;

import com.clebs.interfaces.Borrowable;

public class Equipment implements Borrowable {

// Attributes
private String equipmentId;
private String equipmentName;
private String category;
private int quantity;
private String condition;

// Constructor
public Equipment(String equipmentId, String equipmentName,
                String category, int quantity, String condition) {

    this.equipmentId = equipmentId;
    this.equipmentName = equipmentName;
    this.category = category;
    this.quantity = quantity;
    this.condition = condition;
}

// Getters
public String getEquipmentId() {
    return equipmentId;
}

public String getEquipmentName() {
    return equipmentName;
}

public String getCategory() {
    return category;
}

public int getQuantity() {
    return quantity;
}

public String getCondition() {
    return condition;
}

// Setters
public void setEquipmentName(String equipmentName) {
    this.equipmentName = equipmentName;
}

public void setCategory(String category) {
    this.category = category;
}

public void setQuantity(int quantity) {
    if (quantity >= 0) {
        this.quantity = quantity;
    } else {
        System.out.println("Quantity cannot be negative.");
    }
}

public void setCondition(String condition) {
    this.condition = condition;
}

// Borrow equipment
@Override
public void borrowItem() {
    if (quantity > 0) {
        quantity--;
        System.out.println(equipmentName + " successfully borrowed.");
    } else {
        System.out.println(equipmentName + " is unavailable.");
    }
}

// Return equipment
@Override
public void returnItem() {
    quantity++;
    System.out.println(equipmentName + " successfully returned.");
}

// Check availability
@Override
public boolean isAvailable() {
    return quantity > 0;
}

// Display equipment information
public void displayEquipmentInfo() {
    System.out.println("\n------------------------------");
    System.out.println("Equipment ID: " + equipmentId);
    System.out.println("Equipment Name: " + equipmentName);
    System.out.println("Category: " + category);
    System.out.println("Available Quantity: " + quantity);
    System.out.println("Condition: " + condition);
    System.out.println("------------------------------");
}

}
