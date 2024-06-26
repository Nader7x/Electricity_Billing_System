/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myClasses;

/**
 *
 * @author MAZEN
 */
public class Contract {
    private boolean commercialOrNot;
    private String city;
    private String region;
    private String streetName;
    private int buildingNumber;
    private int apartmentNumber;
    
    FileHandler fh = new FileHandler(FilePaths.contractFile);
    
    public Contract(boolean commercialOrNot, String city, String region, String streetName, int buildingNumber, int apartmentNumber,int customerId) 
    {
        fh.createFile();
        this.commercialOrNot = commercialOrNot;
        this.city = city;
        this.region = region;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        
        fh.writeToFile(customerId);
        fh.writeToFile(commercialOrNot);
        fh.writeToFile(region);
    }

    

    public void setCommercialOrNot(boolean commercialOrNot) {
        this.commercialOrNot = commercialOrNot;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setBuildingNumber(int buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public boolean isCommercialOrNot() {
        return commercialOrNot;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }
    
    
    
}
