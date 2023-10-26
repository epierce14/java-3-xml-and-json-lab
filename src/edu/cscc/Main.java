package edu.cscc;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Pass a variable list of classes to the class that it will use for
            // marshalling and unmarshalling
            JAXBContext context = JAXBContext.newInstance(EmployeesDocument.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Employees employees = (Employees) unmarshaller.unmarshal(new File("./employees.xml"));

            employees.getEmployees().forEach(System.out::println);

            Employees invalidEmployees = new Employees();

            for (int i = 0; i < employees.getEmployees().size(); i++) {
                if (!(employees.getEmployees().get(i).getId().startsWith("2") && (employees.getEmployees().get(i).getId().endsWith("A") ||
                        employees.getEmployees().get(i).getId().endsWith("S") || employees.getEmployees().get(i).getId().endsWith("M")))) {

                    invalidEmployees.getEmployees().add(employees.getEmployees().get(i));
                    employees.getEmployees().remove(employees.getEmployees().get(i));
                    i--;
                }
            }

            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(invalidEmployees, new File("invalidEmployees.xml"));

            Converter converter = new Converter(employees);

            Gson gson = new Gson();

            String output = gson.toJson(converter.getEmployees());
            FileWriter fileWriter = new FileWriter("employees.json");
            fileWriter.write(output);
            fileWriter.close();

            output = gson.toJson(converter.getStores());
            fileWriter = new FileWriter("stores.json");
            fileWriter.write(output);
            fileWriter.close();

            //String fileLocation = System.getProperty("user.dir") + File.separator + "employees.xml";
            //System.out.println(fileLocation);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
