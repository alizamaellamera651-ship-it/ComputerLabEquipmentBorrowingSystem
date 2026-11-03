package com.clebs.models;

public class LaboratoryAdministrator extends User {

    private String employeeId;
    private String department;

    // Constructor
    public LaboratoryAdministrator(String userId, String fullName,
                                  String username, String password,
                                  String employeeId, String department) {

        super(userId, fullName, username, password);

        this.employeeId = employeeId;
        this.department = department;
    }

    // Getters
    public String getEmployeeId() {
        return employeeId;
    }

    public String getDepartment() {
        return department;
    }

    // Display Administrator Dashboard
    @Override
    public void displayDashboard() {
        System.out.println("\n====================================");
        System.out.println("   LABORATORY ADMINISTRATOR");
        System.out.println("====================================");
        System.out.println("Welcome, " + getFullName() + "!");
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Department: " + department);
        System.out.println("====================================");
    }
}