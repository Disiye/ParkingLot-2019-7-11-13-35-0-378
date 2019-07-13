package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ParkingBoyTest {
    //AC1
    @Test
    public void should_return_ticket_when_car_in_parking_lot() throws Exception {
        //given
        Car car = new Car("粤C 888888");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket = parkingBoy.takeMyTicket(car);
        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_given_ticket() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car parkingCar = new Car("粤C 888888");
        Ticket ticket = parkingBoy.takeMyTicket(parkingCar);
        Assertions.assertEquals(parkingCar, parkingBoy.takeMyCar(ticket));
    }

    @Test
    public void should_return_my_car_when_given_ticket() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();
        Car parkingCar = new Car("粤C 888888");
        Ticket ticket = parkingBoy.takeMyTicket(parkingCar);
        Assertions.assertEquals(parkingCar.getCarLicenseNumber(), parkingBoy.takeMyCar(ticket).getCarLicenseNumber());
    }

    //AC2
    @Test
    public void should_return_tickets_when_parking_boy_park_multiple_cars() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();

        Car firstCar = new Car("粤C 111111");
        Car secondCar = new Car("粤C 222222");
        Ticket firstTicket = parkingBoy.takeMyTicket(firstCar);
        Ticket secondTicket = parkingBoy.takeMyTicket(secondCar);

        Assertions.assertEquals(firstTicket.getCarLicenseNumber(), firstCar.getCarLicenseNumber());
        Assertions.assertEquals(secondTicket.getCarLicenseNumber(), secondCar.getCarLicenseNumber());
    }

    @Test
    public void should_return_cars_when_given_ticket() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();

        Car firstCar = new Car("粤C 111111");
        Car secondCar = new Car("粤C 222222");
        Ticket firstTicket = parkingBoy.takeMyTicket(firstCar);
        Ticket secondTicket = parkingBoy.takeMyTicket(secondCar);

        Assertions.assertEquals(firstCar, parkingBoy.takeMyCar(firstTicket));
        Assertions.assertEquals(secondCar, parkingBoy.takeMyCar(secondTicket));
    }

    //AC3
    @Test
    public void should_get_exception_when_give_wrong_ticket() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();

        Car car = new Car("粤C 888888");
        Ticket wrongTicket = new Ticket("粤C 888888");
        parkingBoy.takeMyTicket(car);
        Assertions.assertThrows(Exception.class, () -> parkingBoy.fetch(wrongTicket));
    }

    @Test
    public void should_get_exception_when_dont_give_wrong_ticket() throws Exception {
        ParkingBoy parkingBoy = new ParkingBoy();

        Car car = new Car("粤C 888888");
        Ticket nullTicket = new Ticket(null);
        parkingBoy.takeMyTicket(car);
        Assertions.assertThrows(Exception.class, () -> parkingBoy.fetch(nullTicket));
    }

//    @Test
//    public void should_get_exception_when_give_ticket_has_been_used() throws Exception {
//        ParkingBoy parkingBoy = new ParkingBoy();
//
//        Car car = new Car("粤C 888888");
//        Ticket ticket = parkingBoy.takeMyTicket(car);
//        parkingBoy.fetch(ticket);
//        Assertions.assertThrows(Exception.class, () -> parkingBoy.fetch(ticket));
//    }

    //AC 5
    @Test
    void should_get_exception_when_fetch_car_and_parkingLot_is_not_full() {
        ParkingBoy parkingBoy = new ParkingBoy();

        int capacity = 10;
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (int i = 0; i < capacity; i++) {
            try {
                Ticket ticket = parkingBoy.takeMyTicket(new Car("粤C 888888"));
                tickets.add(ticket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Assertions.assertEquals(capacity, tickets.size());
    }

    @Test
    void should_get_exception_when_fetch_car_and_parkingLot_is_full() {
        ParkingBoy parkingBoy = new ParkingBoy();
        Assertions.assertThrows(Exception.class, () -> {
            for (int i = 0; i < 11; i++) {
                parkingBoy.takeMyTicket(new Car("粤C 888888"));
            }
        });
    }

}


