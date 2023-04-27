package com.example.records;

import java.util.Date;

//Celisha Daramy / 1340551 - Student Hall Application OOP


/**Defining Payment class with one instance variable, amount, which is a String that represents the amount of a payment.*/
public class Payment {
    public String amount;

    public Payment(String amount) {
        this.amount = amount;

    }

    /**
     * @return - toString() method returns the input of the user depending on what option was chosen when application is running. (What amount is provided.)
     */
    public String toString() {
        return " ___ AMOUNT: " + amount;
    }

    /**@return of amount value*/
    public String getAmount() {
        return amount;
    }
}
