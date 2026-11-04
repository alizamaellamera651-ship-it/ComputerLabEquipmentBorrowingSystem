package com.clebs.services;

import java.util.ArrayList;

import com.clebs.models.Equipment;
import com.clebs.repositories.EquipmentRepository;

public class EquipmentService {


private EquipmentRepository equipmentRepository;

// Constructor
public EquipmentService(EquipmentRepository equipmentRepository) {
    this.equipmentRepository = equipmentRepository;
}

// Add equipment
public void addEquipment(Equipment equipment) {

    if (equipment == null) {
        System.out.println("Invalid equipment information.");
        return;
    }

    equipmentRepository.addEquipment(equipment);
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

    return equipmentRepository.deleteEquipment(equipmentId);
}


}
