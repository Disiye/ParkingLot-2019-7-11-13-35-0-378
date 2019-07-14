package com.thoughtworks.tdd;

import java.util.BitSet;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private static int capacity = 10;
    private HashMap<Ticket, Car> ticketCars;
    private List<ParkingBoy> parkingBoys;
    private Manager manager;

    public ParkingLot() {
        capacity = 10;
        this.ticketCars = new HashMap<>(0);
    }

    public ParkingLot(int capacity) {
        ParkingLot.capacity = capacity;
        this.ticketCars = new HashMap<>(0);
    }

//    public ParkingLot(Manager manager) {
//        ParkingLot.capacity = 10;
//        this.ticketCars = new HashMap<>(0);
//        this.manager = manager;
//        manager.allocateParkingLot(this);
//    }
//
//    public ParkingLot(int capacity, Manager manager) {
//        ParkingLot.capacity = capacity;
//        this.ticketCars = new HashMap<>(0);
//        this.manager = manager;
//        manager.allocateParkingLot(this);
//    }

    public HashMap<Ticket, Car> getTicketCars() {
        return ticketCars;
    }

    public Ticket park(Car car) throws Exception {
        if (this.isCapacityFull()) {
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
        return ticketCars.size() >= capacity;
    }


    public double getParkingLotPositionRate() {
        double positionRate = (capacity - ticketCars.size()) / capacity;
        return positionRate;
    }
}
