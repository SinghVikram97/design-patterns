package org.vikram.problems.parkinglot;

import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSlot> findAvailableSpot(Vehicle vehicle, ParkingLotFloor parkingLotFloor);
}
