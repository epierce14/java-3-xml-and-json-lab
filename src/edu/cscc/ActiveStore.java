package edu.cscc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "ActiveStore")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActiveStore implements Serializable {

    @XmlAttribute
    private String storeNumber;
    private String AddressLine1;
    private String City;
    private String State;
    private String Zip;

    public ActiveStore() {

    }

    public ActiveStore(String storeNumber, String AddressLine1, String City, String State, String Zip) {
        this.storeNumber = storeNumber;
        this.AddressLine1 = AddressLine1;
        this.City = City;
        this.State = State;
        this.Zip = Zip;
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    public String getAddressLine() {
        return AddressLine1;
    }

    public void setAddressLine(String addressLine) {
        this.AddressLine1 = AddressLine1;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        this.State = State;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        this.Zip = Zip;
    }

    @Override
    public String toString() {
        return "ActiveStore{" +
                "storeNumber=" + storeNumber +
                ", AddressLine1='" + AddressLine1 + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", Zip='" + Zip + '\'' +
                '}';
    }
}
