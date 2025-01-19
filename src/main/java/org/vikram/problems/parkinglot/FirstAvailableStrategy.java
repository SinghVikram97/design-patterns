package org.vikram.problems.parkinglot;

import java.util.Optional;

public class FirstAvailableStrategy implements ParkingStrategy{
    @Override
    public Optional<ParkingSlot> findAvailableSpot(Vehicle vehicle, ParkingLotFloor parkingLotFloor) {
        return Optional.empty();
    }
}
