package com.thoughtworks.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy {
    public SuperSmartParkingBoy(){}

    public SuperSmartParkingBoy(int parkingLotCount) {
        super(parkingLotCount);
    }

    @Override
    public Ticket takeMyTicket(Car car) throws Exception {
        if (checkParkingLotFull()) {
            throw new Exception("Not enough position.");
        } else {
            ParkingLot parkingLot = getParkingLots().stream()
                    .filter(item -> !(item.isCapacityFull()))
                    .sorted(Comparator.comparing(ParkingLot::getParkingLotPositionRate))
                    .collect(Collectors.toList()).get(0);
            return parkingLot.park(car);
        }
    }
}
