package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParkingBoyTest {
    //AC1
    @Test
    public void should_return_ticket_when_car_in_parking_lot() {
        //given
        Car car = new Car("粤C 888888");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket = parkingBoy.park(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_given_ticket() {
        //given
        Ticket ticket = new Ticket("粤C 888888");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Car car = parkingBoy.takeMyCar(ticket);
        //then
        Assertions.assertNotNull(car);
    }

    @Test
    public void should_return_my_car_when_given_ticket() {

        Ticket ticket = new Ticket("粤C 888888");
        Car car = new Car("粤C 888888");
        ParkingBoy parkingBoy = new ParkingBoy();

        Assertions.assertEquals(car.getCarLicenseNumber(), parkingBoy.takeMyCar(ticket).getCarLicenseNumber());
    }

    @Test
    public void should_return_my_ticket_when_given_car() {

        Ticket ticket = new Ticket("粤C 888888");
        Car car = new Car("粤C 888888");
        ParkingBoy parkingBoy = new ParkingBoy();

        Assertions.assertEquals(ticket.getCarLicenseNumber(),parkingBoy.takeMyTicket(car).getCarLicenseNumber());
    }
}


