package edu.cscc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesDocument implements Serializable {

    @XmlElement(name = "Employees")
    private Employees employees;

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeesDocument {" +
                "employees=" + employees +
                '}';
    }

}
