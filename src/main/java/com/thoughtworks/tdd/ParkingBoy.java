package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {

    private String errorMsg;

    public ParkingBoy() {
        parkingLots = new ArrayList<>(0);
        parkingLots.add(new ParkingLot());
    }

    public ParkingBoy(int parkingLotCount) {
        parkingLots = new ArrayList<>(0);
        for (int i = 0; i < parkingLotCount; i++) {
            parkingLots.add(new ParkingLot());
        }
    }

    public ParkingBoy(int parkingLotCount, int capacity) {
        parkingLots = new ArrayList<>(0);
        for (int i = 0; i < parkingLotCount; i++) {
            parkingLots.add(new ParkingLot(capacity + (i + 1) * 2));
        }
    }

    public Car takeMyCar(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new Exception("Unrecognized parking ticket.");
        } else {
            return parkingLots.stream()
                    .filter(e -> e.getTicketCars().containsKey(ticket))
                    .collect(Collectors.toList()).get(0).fetchCar(ticket);
        }
    }

    public Ticket takeMyTicket(Car car) throws Exception {
        if (checkParkingLotFull()) {
            throw new Exception("Not enough position.");
        } else {
            ParkingLot parkingLot = new ArrayList<>(parkingLots).get(0);
            return parkingLot.park(car);
        }
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    private List<ParkingLot> parkingLots;

    public boolean checkParkingLotFull() {
        return this.parkingLots.stream().allMatch(ParkingLot::isCapacityFull);
    }

    public Car fetch(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new Exception("Parking ticket is empty.");
        } else {
            return parkingLots.stream()
                    .filter(e -> e.getTicketCars().containsKey(ticket))
                    .collect(Collectors.toList()).get(0).fetchCar(ticket);
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
}
