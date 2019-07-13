package com.thoughtworks.tdd;

public class ParkingBoy {
    ParkingLot parkingLot = new ParkingLot();
    public Ticket park(Car car) {
        return parkingLot.getTcket(car.getCarLicenseNumber());
    }

    public Car takeMyCar(Ticket ticket) {
        return parkingLot.getMyCat(ticket.getCarLicenseNumber());
    }

    public Ticket takeMyTicket(Car car) {
        return parkingLot.getMyTicket(car.getCarLicenseNumber());
    }
}
