import edu.cscc.Converter;
import edu.cscc.Employees;
import edu.cscc.EmployeesDocument;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConverterTest {

    @Test
    public void canConvertEmployees() throws JAXBException {

        String result = "[{firstName=Jim, lastName=Kirkbride, payRate=10.5, id=23945809289, role=shift_manager, " +
                "storeNumber=39458}, {firstName=Bob, lastName=Deal, payRate=23.5, id=23945800001, role=store_manager, " +
                "storeNumber=39458}, {firstName=Wynter, lastName=Miller, payRate=10.5, id=23945810408, role=shift_manager, " +
                "storeNumber=39596}, {firstName=Max, lastName=Daniels, payRate=9.0, id=23945800003, role=associate, " +
                "storeNumber=39458}, {firstName=Lana, lastName=Williams, payRate=9.5, id=33945800001, role=associate, " +
                "storeNumber=39311}, {firstName=Leah, lastName=Williams, payRate=9.75, id=23945800002, role=store_manager, " +
                "storeNumber=39311}, {firstName=James, lastName=Budai, payRate=10.0, id=2393110442, role=associate, " +
                "storeNumber=39311}, {firstName=Dalaina, lastName=Johnson, payRate=9.25, id=23945809295, role=associate, " +
                "storeNumber=39458}]";
        JAXBContext context = JAXBContext.newInstance(EmployeesDocument.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Employees employees = (Employees) unmarshaller.unmarshal(new File("./employees.xml"));
        Converter converter = new Converter(employees);

        assertEquals(result, converter.convertEmployees().toString());
    }

    @Test
    public void canConvertStores() throws JAXBException {

        String result = "[{storeNumber=39458, addressLine1=3040 Harrisburg Pike, city=Columbus, state=OH, zip=43223, " +
                "employees=[23945809289, 23945800001, 23945800003, 23945809295]}, {storeNumber=39596, " +
                "addressLine1=1000 W. Broad St, city=Columbus, state=OH, zip=43228, employees=[23945810408]}, " +
                "{storeNumber=39311, addressLine1=100 Stringtown Rd, city=Grove City, state=OH, zip=43123, " +
                "employees=[33945800001, 23945800002, 2393110442]}]";
        JAXBContext context = JAXBContext.newInstance(EmployeesDocument.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Employees employees = (Employees) unmarshaller.unmarshal(new File("./employees.xml"));
        Converter converter = new Converter(employees);

        assertEquals(result, converter.convertStores().toString());
    }
}

