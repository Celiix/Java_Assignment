package com.example.records;

// Celisha Daramy / 1340551 - Student Hall Application OOP


import java.time.LocalDate;
import java.util.Date;

/**
 * Defining Employee class with the inheritance of the Person class (Person is the superclass!)
 */
public class Employee extends Person {

    /**
     * employeeID has the same arguments as 'Person'
     * Employee class attribute
     */
    public String employeeID;

    /**
     * All attributes will be shown in the application for the users' input.
     * @param name
     * @param gender
     * @param dateOfBirth
     * @param age
     * @param address
     * @param nationality
     * @param registrationDate
     * @param employeeID
     */
    public Employee(String name, String gender, LocalDate dateOfBirth, int age, String address, String nationality, LocalDate registrationDate, String employeeID) {
        super(name, gender, dateOfBirth, age, address, nationality, registrationDate);
        this.employeeID = employeeID;
    }

    /**
     * @return value of employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return - super.toString() method will be called to gather the string representation of the 'Person' object and then returned.
     */
    public String toString() {
        return super.toString() + " ___ ID: " + employeeID;
    }
}
