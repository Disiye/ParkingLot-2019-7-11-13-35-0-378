package com.thoughtworks.tdd;

import java.util.List;

public class Ticket {
    private String carLicenseNumber;
    private List<String> carLicenseList;

    public Ticket(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    public Ticket(List<String> carLicenseList) {
        this.carLicenseList = carLicenseList;
    }


    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }

    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    public List<String> getCarLicenseList() {
        return carLicenseList;
    }

    public void setCarLicenseList(List<String> carLicenseList) {
        this.carLicenseList = carLicenseList;
    }
}
