package org.vikram.problems.parkinglot;

public class Main {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = ParkingLot.getParkingLot();

        parkingLot.addFloor(1, 3);
        parkingLot.addFloor(2, 3);

        Vehicle car1 = new Car("ABCD");
        String ticketNumber1 = parkingLot.parkVehicle(car1, 2);

        Vehicle car2 = new Car("FGHI");
        String ticketNumber2 = parkingLot.parkVehicle(car2, 1);

        Vehicle car3 = new Car("XYZ");
        String ticketNumber3 = parkingLot.parkVehicle(car3, 2);

        parkingLot.unparkVehicle(ticketNumber1);

        Vehicle car4 = new Car("NEW");
        // Will be parked at slot 0 at floor 2 since car1 is unparked now
        String ticketNumber4 = parkingLot.parkVehicle(car4, 2);
    }
}
