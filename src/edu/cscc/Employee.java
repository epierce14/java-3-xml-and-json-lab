package edu.cscc;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee implements Serializable {

    @XmlAttribute
    private String id;

    private String FirstName;
    private String LastName;
    private double PayRate;
    private ActiveStore ActiveStore;

    public Employee() {

    }

    public Employee(String id, String FirstName, String LastName, double PayRate, ActiveStore ActiveStore) {
        this.id = id;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.ActiveStore = ActiveStore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public double getPayRate() {
        return PayRate;
    }

    public void setPayRate(double PayRate) {
        this.PayRate = PayRate;
    }

    public ActiveStore getActiveStore() {
        return ActiveStore;
    }

    public void setActiveStore(ActiveStore ActiveStore) {
        this.ActiveStore = ActiveStore;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", PayRate=" + PayRate +
                ", ActiveStore=" + ActiveStore +
                '}';
    }
}
