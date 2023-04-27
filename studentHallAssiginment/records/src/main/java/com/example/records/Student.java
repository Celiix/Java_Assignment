package com.example.records;

import java.time.LocalDate;
import java.util.Date;

// Celisha Daramy / 1340551 - Student Hall Application OOP


/**
 * Defining Student class with the inheritance of the Person class (Person is the superclass!)
 */
public class Student extends Person {

    /**
     * studentID has the same arguments as 'Person'
     * Student class attribute
     */
    public String studentID;


    public Student(String name, String gender, LocalDate dateOfBirth, int age, String address, String nationality, LocalDate registrationDate, String studentID) {
        super(name, gender, dateOfBirth, age, address, nationality, registrationDate);
        this.studentID = studentID;
    }

    /**
     * @return value of studentID
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     *@return - super.toString() method will be called to gather the string representation of the 'Person' object and then return.
     */

    public String toString() {
        return super.toString() + " ___ ID: " + studentID;
    }
}
