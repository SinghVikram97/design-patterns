package org.vikram.problems.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ParkingLotFloor {
    private final int floorNumber;
    private final HashMap<Integer, ParkingSlot> parkingSlots;

    public ParkingLotFloor(int floorNumber, int totalSlots) {
        this.floorNumber = floorNumber;
        this.parkingSlots = new HashMap<>();
        // 75% of total slots for cars and 25% for bikes
        initializeSlots(totalSlots);
    }

    private void initializeSlots(int totalSlots){
        int slotsForCar = (int) (totalSlots*(0.75));

        for(int i=0;i<slotsForCar;i++){
            parkingSlots.put(i, new CarParkingSlot(i, floorNumber));
        }

        for(int i=slotsForCar;i<totalSlots;i++){
            parkingSlots.put(i, new MotorCycleParkingSlot(i, floorNumber));
        }
    }

    public List<ParkingSlot> getAllParkingSlots(){
        return parkingSlots.values().stream().collect(Collectors.toUnmodifiableList());
    }

    public ParkingSlot getParkingSlot(int slotId){
        return parkingSlots.get(slotId);
    }

    public int getFloorNumber() {
        return floorNumber;
    }
}
