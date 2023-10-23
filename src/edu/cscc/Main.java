package edu.cscc;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String fileLocation = System.getProperty("user.dir") + File.separator + "employees.xml";
        System.out.println(fileLocation);
    }
}
