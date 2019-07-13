package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private ParkingLot parkingLot = new ParkingLot();

    public ParkingBoy() {
        parkingLots = new ArrayList<>(0);
        parkingLots.add(new ParkingLot());
    }

    public Car takeMyCar(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new Exception("Parking ticket is empty.");
        } else {
            return parkingLots.stream()
                    .filter(e -> e.getTicketCars().containsKey(ticket))
                    .collect(Collectors.toList()).get(0).fetchCar(ticket);
        }
    }

    public Ticket takeMyTicket(Car car) throws Exception {
        if (checkParkingLotFull()) {
            throw new Exception("The car park is full.");
        } else {
            ParkingLot parkingLot = new ArrayList<>(parkingLots).get(0);
            return parkingLot.park(car);
        }
    }

    private List<ParkingLot> parkingLots;

    public boolean checkParkingLotFull() {
        return this.parkingLots.stream().allMatch(ParkingLot::isCapacityFull);
    }

    public void fetch(Ticket ticket) throws Exception {
        if (ticket == null) {
            throw new Exception("Parking ticket is empty.");
        } else {
            parkingLots.stream()
                    .filter(e -> e.getTicketCars().containsKey(ticket))
                    .collect(Collectors.toList()).get(0).fetchCar(ticket);
        }
    }
}
