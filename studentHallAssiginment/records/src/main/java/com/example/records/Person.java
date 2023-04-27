package com.example.records;

import java.time.LocalDate;
import java.util.Date;

// Celisha Daramy / 1340551 - Student Hall Application OOP



/**Defining Person class/ contains all attributes about the user.*/
public class Person {
    public String name;
    public String gender;
    public LocalDate dateOfBirth;
    public int age;
    public String address;
    public String nationality;
    public LocalDate registrationDate;

    /**
     * All attributes will be shown in the application for the users' input.
     * @param name
     * @param gender
     * @param dateOfBirth
     * @param age
     * @param address
     * @param nationality
     * @param registrationDate
     */
    public Person(String name, String gender, LocalDate dateOfBirth, int age, String address, String nationality, LocalDate registrationDate) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.address = address;
        this.nationality = nationality;
        this.registrationDate = registrationDate;
    }


    /**@return - getters and setters/ returns the value of the attributes*/
    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getNationality() {
        return nationality;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @returns a string that presents itself as a Person object.
     */
    public String toString() {
        return "NAME: " + name + " ___ GENDER: " + gender + " ___ AGE" + age + " ___ DOB: " + dateOfBirth + " ___ ADDRESS: " + address + " ___ NATIONALITY: " + nationality + " ___ DOR: " + registrationDate;
    }
}

