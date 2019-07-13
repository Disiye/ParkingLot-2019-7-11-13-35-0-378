package com.thoughtworks.tdd;

import java.util.List;

public class Car {
    private String carLicenseNumber;
    private List<String> carLicenseList;

    public Car(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    public Car(List<String> carLicenseList) {
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
