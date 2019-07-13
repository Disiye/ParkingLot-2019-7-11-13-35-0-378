package com.thoughtworks.tdd;

public class ParkingLot {
    public Ticket getTcket(String carLicenseNumber) {
        return new Ticket(carLicenseNumber);
    }

    public Car getMyCat(String carLicenseNumber) {
        return new Car(carLicenseNumber);
    }

    public Ticket getMyTicket(String carLicenseNumber) {
        return new Ticket(carLicenseNumber);
    }
}
