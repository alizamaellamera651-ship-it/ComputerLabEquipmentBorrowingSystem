package com.clebs.controllers;

import java.util.ArrayList;

import com.clebs.models.Equipment;
import com.clebs.repositories.EquipmentRepository;
import com.clebs.services.EquipmentService;

public class EquipmentController {


private EquipmentService equipmentService;

// Constructor
public EquipmentController() {
    EquipmentRepository equipmentRepository = new EquipmentRepository();
    equipmentService = new EquipmentService(equipmentRepository);
}

// Add equipment
public void addEquipment(Equipment equipment) {
    equipmentService.addEquipment(equipment);
}

// View all equipment
public ArrayList<Equipment> getAllEquipment() {
    return equipmentService.getAllEquipment();
}

// Search equipment
public Equipment searchEquipment(String equipmentId) {
    return equipmentService.searchEquipment(equipmentId);
}

// Update equipment
public boolean updateEquipment(String equipmentId, String name,
                              String category, int quantity,
                              String condition) {

    return equipmentService.updateEquipment(
            equipmentId, name, category, quantity, condition);
}

// Delete equipment
public boolean deleteEquipment(String equipmentId) {
    return equipmentService.deleteEquipment(equipmentId);
}

}
