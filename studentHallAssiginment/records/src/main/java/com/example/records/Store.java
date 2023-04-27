package com.example.records;

import java.util.ArrayList;

// Celisha Daramy / 1340551 - Student Hall Application OOP

 /**
 * Defining Store class used to store data from Person objects/ An array list with the usage to store objects of the Person class.
 */
public class Store {
    public ArrayList<Person> people;


    public Store() {
        this.people = new ArrayList<>();
    }

    /**
     * @param person - add a person
     */
    public void addPerson(Person person) {
        people.add(person);
    }

    /**
     * @param person - Remove a person
     */
    public void removePerson(Person person) {
        people.remove(person);
    }

    /**
     * @return value of "People"
     */
    public ArrayList<Person> getPeople() {
        return people;
    }
}
