package com.clebs.repositories;

import java.util.ArrayList;
import com.clebs.models.Equipment;

public class EquipmentRepository {

private ArrayList<Equipment> equipmentList;

// Constructor
public EquipmentRepository() {
    equipmentList = new ArrayList<>();
}

/// Add equipment
public void addEquipment(Equipment equipment) {
    equipmentList.add(equipment);
}

// View all equipment
public ArrayList<Equipment> getAllEquipment() {
    return equipmentList;
}

// Find equipment by ID
public Equipment findEquipmentById(String equipmentId) {

    for (Equipment equipment : equipmentList) {

        if (equipment.getEquipmentId().equalsIgnoreCase(equipmentId)) {
            return equipment;
        }
    }

    return null;
}

// Update equipment
public boolean updateEquipment(String equipmentId, String newName,
                               String newCategory, int newQuantity,
                               String newCondition) {

    Equipment equipment = findEquipmentById(equipmentId);

    if (equipment != null) {
        equipment.setEquipmentName(newName);
        equipment.setCategory(newCategory);
        equipment.setQuantity(newQuantity);
        equipment.setCondition(newCondition);

        return true;
    }

    return false;
}
// Delete equipment
public boolean deleteEquipment(String equipmentId) {

    Equipment equipment = findEquipmentById(equipmentId);

    if (equipment != null) {
        equipmentList.remove(equipment);
        return true;
    }

    return false;
}

}
