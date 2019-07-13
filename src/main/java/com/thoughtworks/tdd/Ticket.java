package com.thoughtworks.tdd;

public class Ticket {
    private String carLicenseNumber;

    public Ticket(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }

    public String getCarLicenseNumber() {
        return carLicenseNumber;
    }

    public void setCarLicenseNumber(String carLicenseNumber) {
        this.carLicenseNumber = carLicenseNumber;
    }
}
