package edu.cscc;

import java.io.Serializable;

public class EmployeesDocument implements Serializable {

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
