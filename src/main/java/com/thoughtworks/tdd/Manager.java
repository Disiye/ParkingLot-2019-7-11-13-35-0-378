package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy{

    private List<ParkingBoy> parkingBoyList;
    private ParkingLot parkingLot;
    public Manager() {
        super();
        parkingBoyList = new ArrayList<>(0);
        parkingLot = new ParkingLot();
    }

    public Manager(List<ParkingBoy> parkingBoyList) {
        this.parkingBoyList = parkingBoyList;
    }

    public List<ParkingBoy> getParkingBoyList() {
        return parkingBoyList;
    }

    public void addParkingBoy(ParkingBoy parkingBoy){
        parkingBoyList.add(parkingBoy);
    }

    @Override
    public Car fetch(Ticket ticket) throws Exception {
        return parkingLot.fetchCar(ticket);
    }

    @Override
    public Ticket takeMyTicket(Car car) throws Exception {
        if (checkParkingLotFull()) {
            throw new Exception("Not enough position.");
        } else {
            return parkingLot.park(car);
        }
    }
}
