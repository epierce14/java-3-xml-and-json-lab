package edu.cscc;

import java.io.Serializable;

public class Employee implements Serializable {
    private String firstName;
    private String lastName;
    private double payRate;
    private ActiveStore activeStore;

    public Employee() {

    }

    public Employee(String firstName, String lastName, double payRate, ActiveStore activeStore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.activeStore = activeStore;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public ActiveStore getActiveStore() {
        return activeStore;
    }

    public void setActiveStore(ActiveStore activeStore) {
        this.activeStore = activeStore;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", payRate=" + payRate +
                ", activeStore=" + activeStore +
                '}';
    }
}
