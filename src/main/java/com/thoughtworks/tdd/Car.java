package com.thoughtworks.tdd;

public class Car {
    private String carLicenseNumber;

    public Car(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }

    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }
}
