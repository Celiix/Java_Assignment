package com.example.records;

import java.util.ArrayList;

// Celisha Daramy / 1340551 - Student Hall Application OOP



/**
 * Defining Hall class for residents
 */
public class Hall {

    /**
     * Hall class variables with an array list of 'Person' objects.
     */
    public String hallName;
    public ArrayList<Person> residents;
    public ArrayList<Payment> payments;

    /**
     * @param hallName -Hall is the constructor and hallName is the parameter/ creates an empty array list for residents and payments variables.
     */
    public Hall(String hallName) {
        this.hallName = hallName;
        this.residents = new ArrayList<>();
        this.payments = new ArrayList<>();
    }

    /**
     * @return - Getters to return value.
     */

    public String getHallName() {
        return hallName;
    }

    public ArrayList<Person> getResidents() {
        return residents;
    }

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    /**
     * @param resident - Add a resident
     */
    public void addResident(Person resident) {
        residents.add(resident);
    }

    /**
     * @param resident - Remove a resident
     */
    public void removeResident(Person resident) {
        residents.remove(resident);
    }

    /**
     * @param payment -  Add payment for residence
     */
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    /**
     * @param payment Remove payment for residence
     */
    public void removePayment(Payment payment) {
        payments.remove(payment);
    }

    /**
     * @return value of hall name.
     */
    public String toString() {
        return " ___ HALL NAME: " + hallName;
    }
}
