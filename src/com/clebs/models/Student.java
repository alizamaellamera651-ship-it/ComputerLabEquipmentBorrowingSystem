package com.clebs.models;

public class Student extends User {

    private String studentId;
    private String course;
    private String yearLevel;

    // Constructor
    public Student(String userId, String fullName, String username, String password,
                   String studentId, String course, String yearLevel) {

        super(userId, fullName, username, password);

        // Validate student information
if (studentId == null || studentId.trim().isEmpty()) {
    throw new IllegalArgumentException("Student ID cannot be empty.");
}

if (course == null || course.trim().isEmpty()) {
    throw new IllegalArgumentException("Course cannot be empty.");
}

if (yearLevel == null || yearLevel.trim().isEmpty()) {
    throw new IllegalArgumentException("Year level cannot be empty.");
}

this.studentId = studentId.trim();
this.course = course.trim();
this.yearLevel = yearLevel.trim();
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getCourse() {
        return course;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    // Display Student Dashboard
    @Override
    public void displayDashboard() {
        System.out.println("\n====================================");
        System.out.println("       STUDENT DASHBOARD");
        System.out.println("====================================");
        System.out.println("Welcome, " + getFullName() + "!");
        System.out.println("Student ID: " + studentId);
        System.out.println("Course: " + course);
        System.out.println("Year Level: " + yearLevel);
        System.out.println("====================================");
    }
}