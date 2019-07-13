package com.thoughtworks.tdd;

public class ParkingBoy {
    ParkingLot parkingLot = new ParkingLot();

    public Ticket park(Car car) {
        return parkingLot.getTcket(car.getCarLicenseNumber());
    }

    public Car takeMyCar(Ticket ticket) {
        if (ticket.getCarLicenseNumber() != null) {
            return parkingLot.getMyCat(ticket.getCarLicenseNumber());
        }
        return parkingLot.getMyCatList(ticket.getCarLicenseList());
    }

    public Ticket takeMyTicket(Car car) {
        if (car.getCarLicenseNumber() != null) {
            return parkingLot.getMyTicker(car.getCarLicenseNumber());
        }
        return parkingLot.getMyTicketList(car.getCarLicenseList());
    }
}
