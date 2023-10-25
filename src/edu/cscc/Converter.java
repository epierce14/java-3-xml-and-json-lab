package edu.cscc;

import java.lang.reflect.Array;
import java.util.*;

public class Converter {

    private Employees employees;

    public Converter(Employees employees) {
        this.employees = employees;
    }

    public ArrayList<LinkedHashMap> getEmployees() {

        LinkedHashMap empConverted = new LinkedHashMap();
        ArrayList<LinkedHashMap> empConvertedArray = new ArrayList<>();


            for (int i = 0; i < employees.getEmployees().size(); i++) {

                empConverted.put("firstName", employees.getEmployees().get(i).getFirstName());
                empConverted.put("lastName", employees.getEmployees().get(i).getLastName());
                empConverted.put("payRate", employees.getEmployees().get(i).getPayRate());
                empConverted.put("id", employees.getEmployees().get(i).getId().substring(0, 11));

                if (employees.getEmployees().get(i).getId().endsWith("A")) {
                    empConverted.put("role", "associate");
                } else if ((employees.getEmployees().get(i).getId().endsWith("S"))) {
                    empConverted.put("role", "shift_manager");
                } else {
                    empConverted.put("role", "store_manager");
                }

                empConverted.put("storeNumber", employees.getEmployees().get(i).getActiveStore().getStoreNumber());

            empConvertedArray.add(empConverted);
        }

        return empConvertedArray;
    }

    public ArrayList<List> getStores() {
        return null;
    }
}
