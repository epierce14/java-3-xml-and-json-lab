package edu.cscc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<LinkedHashMap<String, Object>> getStores() {

        List<LinkedHashMap<String, Object>> storeConverted = new ArrayList<LinkedHashMap<String, Object>>();

        for (int i = 0; i < employees.getEmployees().size(); i++) {

            storeConverted.add(new LinkedHashMap<>());

            storeConverted.get(i).put("storeNumber", employees.getEmployees().get(i).getActiveStore().getStoreNumber());
            storeConverted.get(i).put("addressLine1", employees.getEmployees().get(i).getActiveStore().getAddressLine());
            storeConverted.get(i).put("city", employees.getEmployees().get(i).getActiveStore().getCity());
            storeConverted.get(i).put("state", employees.getEmployees().get(i).getActiveStore().getState());
            storeConverted.get(i).put("zip", employees.getEmployees().get(i).getActiveStore().getZip());
        }

        List<LinkedHashMap<String, Object>> deduped = storeConverted.stream().distinct().collect(Collectors.toList());

        return deduped;
    }
}
