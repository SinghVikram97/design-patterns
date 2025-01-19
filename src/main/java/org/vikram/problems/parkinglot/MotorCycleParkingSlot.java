package org.vikram.problems.parkinglot;

public class MotorCycleParkingSlot extends ParkingSlot{
    public MotorCycleParkingSlot(int id, int floorNumber) {
        super(id, floorNumber);
    }

    @Override
    public boolean canPark(Vehicle vehicle) {
        return vehicle instanceof MotorCycle;
    }


}
