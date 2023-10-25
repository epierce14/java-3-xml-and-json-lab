package edu.cscc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Converter {

    private Employees employees;

    public Converter(Employees employees) {
        this.employees = employees;
    }

    public List<LinkedHashMap<String, Object>> getEmployees() {

        List<LinkedHashMap<String, Object>> empConverted = new ArrayList<LinkedHashMap<String, Object>>();

            for (int i = 0; i < employees.getEmployees().size(); i++) {

                empConverted.add(new LinkedHashMap<>());

                empConverted.get(i).put("firstName", employees.getEmployees().get(i).getFirstName());
                empConverted.get(i).put("lastName", employees.getEmployees().get(i).getLastName());
                empConverted.get(i).put("payRate", employees.getEmployees().get(i).getPayRate());
                empConverted.get(i).put("id", employees.getEmployees().get(i).getId().substring(0, 11));

                if (employees.getEmployees().get(i).getId().endsWith("A")) {
                    empConverted.get(i).put("role", "associate");
                } else if ((employees.getEmployees().get(i).getId().endsWith("S"))) {
                    empConverted.get(i).put("role", "shift_manager");
                } else {
                    empConverted.get(i).put("role", "store_manager");
                }

                empConverted.get(i).put("storeNumber", employees.getEmployees().get(i).getActiveStore().getStoreNumber());

        }

        return empConverted;
    }

    public ArrayList<List> getStores() {
        return null;
    }
}
