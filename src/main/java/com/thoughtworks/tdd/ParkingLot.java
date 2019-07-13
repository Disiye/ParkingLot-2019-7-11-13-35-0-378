package com.thoughtworks.tdd;

import java.util.List;

public class ParkingLot {
    public Ticket getTcket(String carLicenseNumber) {
        return new Ticket(carLicenseNumber);
    }

    public Car getMyCat(String carLicenseNumber) {
        return new Car(carLicenseNumber);
    }

    public Car getMyCatList(List<String> carLicenseList) {
        return new Car(carLicenseList);
    }

    public Ticket getMyTicker(String carLicenseNumber) {
        return new Ticket(carLicenseNumber);
    }

    public Ticket getMyTicketList(List<String> carLicenseList) {
        return new Ticket(carLicenseList);
    }
}
