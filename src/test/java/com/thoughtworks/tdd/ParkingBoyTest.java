package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        Assertions.assertEquals(ticket.getCarLicenseNumber(), parkingBoy.takeMyTicket(car).getCarLicenseNumber());
    }

    //AC2
    @Test
    public void should_return_tickets_when_parking_boy_park_multiple_cars() {

        String[] array = new String[]{"粤C 111111", "粤C 222222", "粤C 333333", "粤C 555555", "粤C 666666", "粤C 777777"};
        List<String> carLicenseList = Arrays.asList(array);

        Ticket ticket = new Ticket(carLicenseList);
        Car car = new Car(carLicenseList);

        ParkingBoy parkingBoy = new ParkingBoy();
        Assertions.assertEquals(ticket.getCarLicenseList(), parkingBoy.takeMyTicket(car).getCarLicenseList());
    }

    @Test
    public void should_return_cars_when_given_car() {

        String[] array = new String[]{"粤C 111111", "粤C 222222", "粤C 333333", "粤C 555555", "粤C 666666", "粤C 777777"};
        List<String> carLicenseList = Arrays.asList(array);

        Ticket ticket = new Ticket(carLicenseList);
        Car car = new Car(carLicenseList);

        ParkingBoy parkingBoy = new ParkingBoy();
        Assertions.assertEquals(car.getCarLicenseList(), parkingBoy.takeMyCar(ticket).getCarLicenseList());
    }
}


