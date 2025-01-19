package org.vikram.problems.parkinglot;

import java.util.Optional;

public class FirstAvailableStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSlot> findAvailableSpot(Vehicle vehicle, ParkingLotFloor parkingLotFloor) {
        return parkingLotFloor.getAllParkingSlots().stream().filter(parkingSlot -> parkingSlot.isAvailable() && parkingSlot.canPark(vehicle)).findFirst();
    }
}
