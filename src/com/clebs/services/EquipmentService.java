package com.clebs.services;

import java.util.ArrayList;

import com.clebs.models.Equipment;
import com.clebs.repositories.EquipmentRepository;
import com.clebs.repositories.BorrowingRepository;

public class EquipmentService {

    private BorrowingRepository borrowingRepository;
    private EquipmentRepository equipmentRepository;

    // Constructor
public EquipmentService(
        EquipmentRepository equipmentRepository,
        BorrowingRepository borrowingRepository) {

    this.equipmentRepository = equipmentRepository;
    this.borrowingRepository = borrowingRepository;
}

    // Add equipment
public boolean addEquipment(Equipment equipment) {

    if (equipment == null) {
        System.out.println("Invalid equipment information.");
        return false;
    }

    if (equipment.getEquipmentId() == null ||
        equipment.getEquipmentId().trim().isEmpty()) {
        System.out.println("Equipment ID cannot be empty.");
        return false;
    }

    if (equipment.getEquipmentName() == null ||
        equipment.getEquipmentName().trim().isEmpty()) {
        System.out.println("Equipment name cannot be empty.");
        return false;
    }

    if (equipment.getCategory() == null ||
        equipment.getCategory().trim().isEmpty()) {
        System.out.println("Category cannot be empty.");
        return false;
    }

    if (equipment.getCondition() == null ||
        equipment.getCondition().trim().isEmpty()) {
        System.out.println("Condition cannot be empty.");
        return false;
    }

    if (equipment.getQuantity() < 0) {
        System.out.println("Quantity cannot be negative.");
        return false;
    }

    if (equipmentRepository.findEquipmentById(
            equipment.getEquipmentId()) != null) {
        System.out.println("Equipment ID already exists.");
        return false;
    }

    // Check for duplicate equipment name
for (Equipment existingEquipment : equipmentRepository.getAllEquipment()) {

    if (existingEquipment.getEquipmentName().trim()
            .equalsIgnoreCase(equipment.getEquipmentName().trim())) {

        System.out.println("Equipment name already exists.");
        return false;
    }
}

    equipmentRepository.addEquipment(equipment);

    return true;
}

    // View all equipment
    public ArrayList<Equipment> getAllEquipment() {
        return equipmentRepository.getAllEquipment();
    }

    // Search equipment
    public Equipment searchEquipment(String equipmentId) {

        if (equipmentId == null || equipmentId.trim().isEmpty()) {
            System.out.println("Equipment ID cannot be empty.");
            return null;
        }

        return equipmentRepository.findEquipmentById(equipmentId);
    }

    // Update equipment
    public boolean updateEquipment(String equipmentId, String name,
                                   String category, int quantity,
                                   String condition) {

        if (equipmentId == null || equipmentId.trim().isEmpty()) {
            System.out.println("Equipment ID cannot be empty.");
            return false;
        }

        if (name == null || name.trim().isEmpty()) {
            System.out.println("Equipment name cannot be empty.");
            return false;
        }

        if (category == null || category.trim().isEmpty()) {
            System.out.println("Category cannot be empty.");
            return false;
        }

        if (condition == null || condition.trim().isEmpty()) {
            System.out.println("Condition cannot be empty.");
            return false;
        }

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return false;
        }

        return equipmentRepository.updateEquipment(
                equipmentId, name, category, quantity, condition);
    }

    // Delete equipment
public boolean deleteEquipment(String equipmentId) {

    if (equipmentId == null || equipmentId.trim().isEmpty()) {
        System.out.println("Equipment ID cannot be empty.");
        return false;
    }

    Equipment equipment =
            equipmentRepository.findEquipmentById(equipmentId);

    if (equipment == null) {
        System.out.println("Equipment not found.");
        return false;
    }

    for (com.clebs.models.BorrowingTransaction transaction :
            borrowingRepository.getAllTransactions()) {

        if (transaction.getEquipment().getEquipmentId()
                .equalsIgnoreCase(equipmentId)
                && transaction.getStatus().equalsIgnoreCase("Borrowed")) {

            System.out.println(
                    "Cannot delete equipment. It is currently borrowed."
            );
            return false;
        }
    }

    return equipmentRepository.deleteEquipment(equipmentId);
}
}