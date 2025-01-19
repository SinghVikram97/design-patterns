package org.vikram.problems.parkinglot;

public class CarParkingSlot extends ParkingSlot{

    public CarParkingSlot(int id, int floorNumber) {
        super(id, floorNumber);
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return vehicle instanceof Car;
    }
}
