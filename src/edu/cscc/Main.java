package edu.cscc;

import com.google.gson.Gson;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This program implements a backup conversion process for Lackluster Video.  It opens the employees backup XML file,
 * converts the file to a new format, and writes the records back out into separate employees and stores JSON files. If invalid
 * records are found during the conversion, they are written out to a invalidEmployees file in the original XML format.
 * <p>
 * Author: Elton Pierce
 * Date: 10/25/2023
 */
public class Main {

    /**
     * Validate method used to separate valid employee data from invalid employee data based on the following rules:
     * 1. The employee id must start with a “2”.
     * 2. The employee id must end in either an “A”, “S”, or “M”.
     */
    static Employees Validate(Employees employees) {

        Employees invalidEmployees = new Employees();

        for (int i = 0; i < employees.getEmployees().size(); i++) {
            if (!(employees.getEmployees().get(i).getId().startsWith("2") && (employees.getEmployees().get(i).getId().endsWith("A") ||
                    employees.getEmployees().get(i).getId().endsWith("S") || employees.getEmployees().get(i).getId().endsWith("M")))) {

                invalidEmployees.getEmployees().add(employees.getEmployees().get(i));
                employees.getEmployees().remove(employees.getEmployees().get(i));
                i--;
            }
        }

        return invalidEmployees;
    }

    public static void main(String[] args) {

        try {
            // Use JAXB to unmarshall the XML file.
            JAXBContext context = JAXBContext.newInstance(EmployeesDocument.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Employees employees = (Employees) unmarshaller.unmarshal(new File("./employees.xml"));

            // Print out data as check that unmarshalling worked.
            employees.getEmployees().forEach(System.out::println);

            // Separate out invalid employees by calling Validate method.
            Employees invalidEmployees = Validate(employees);

            // Use JAXB to marshall the invalid data to an output XML file.
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(invalidEmployees, new File("invalidEmployees.xml"));

            // Create a converter instance.
            Converter converter = new Converter(employees);

            // Initialize Gson.
            Gson gson = new Gson();

            // Use the converter to reformat the employee data and then use Gson to convert the data to json
            // then write the output to a JSON file.
            String output = gson.toJson(converter.convertEmployees());
            FileWriter fileWriter = new FileWriter("employees.json");
            fileWriter.write(output);
            fileWriter.close();

            // Use the converter to reformat the store data and then use Gson to convert the data to json
            // then write the output to a JSON file.
            output = gson.toJson(converter.convertStores());
            fileWriter = new FileWriter("stores.json");
            fileWriter.write(output);
            fileWriter.close();

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }
    }
}
