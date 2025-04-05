package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Apartment {

    String apartmentNo;
    String propertyName;
    Long floorNo;
    Long size;
    Long numberOfRooms;
    List<Lease> leases;

    public Apartment(String apartmentNo, String propertyName, Long floorNo, Long size, Long numberOfRooms) {
        this.apartmentNo = apartmentNo;
        this.propertyName = propertyName;
        this.floorNo = floorNo;
        this.size = size;
        this.numberOfRooms = numberOfRooms;
        this.leases = new ArrayList<>();
    }


    public List<Lease> getLeases() {
        return leases;
    }

    public void addNewLease(Lease lease) {
        this.leases.add(lease);
    }

    public void setLeases(List<Lease> leases) {
        this.leases = leases;
    }

    public Long getFloorNo() {
        return floorNo;
    }

    public Long getSize() {
        return size;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public String getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(String apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }


}
