package edu.cscc;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable {

    @XmlAttribute
    private int id;
    private String firstName;
    private String lastName;
    private double payRate;
    private ActiveStore activeStore;

    public Employee() {

    }

    public Employee(int id, String firstName, String lastName, double payRate, ActiveStore activeStore) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.activeStore = activeStore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", payRate=" + payRate +
                ", activeStore=" + activeStore +
                '}';
    }
}
