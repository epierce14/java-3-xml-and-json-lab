package edu.cscc;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Pass a variable list of classes to the class that it will use for
            // marshalling and unmarshalling
            JAXBContext context = JAXBContext.newInstance(EmployeesDocument.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            Employees employees = (Employees) unmarshaller.unmarshal(new File("./employees.xml"));
            employees.getEmployees().forEach(System.out::println);

            //String fileLocation = System.getProperty("user.dir") + File.separator + "employees.xml";
            //System.out.println(fileLocation);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
