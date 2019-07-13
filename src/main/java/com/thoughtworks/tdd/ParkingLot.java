package com.thoughtworks.tdd;

import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private HashMap<Ticket, Car> ticketCars;

    ParkingLot() {
        this.capacity = 10;
        this.ticketCars = new HashMap<>(0);
    }

    public ParkingLot(Integer capacity) {
        this.capacity = capacity;
        this.ticketCars = new HashMap<>(0);
    }

    public HashMap<Ticket, Car> getTicketCars() {
        return ticketCars;
    }

    public Ticket park(Car car) throws Exception {
        if (ticketCars.containsValue(car)) {
            throw new Exception();
        }
        Ticket ticket = new Ticket(car.getCarLicenseNumber());
        ticketCars.put(ticket, car);
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {
        return ticketCars.remove(ticket);
    }

    public boolean isCapacityFull() {
        return ticketCars.size() >= 10;
    }


}
