package org.vikram.problems.parkinglot;

import java.util.Objects;

public abstract class ParkingSlot {
    private final int id;
    private final int floorNumber;
    protected Vehicle parkedVehicle;

    public ParkingSlot(int id, int floorNumber) {
        this.id = id;
        this.floorNumber = floorNumber;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable(){
        return Objects.isNull(parkedVehicle);
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) {
        this.parkedVehicle = vehicle;
        return new ParkingTicket(vehicle, floorNumber, id);
    }

    public void unparkVehicle() {
        this.parkedVehicle = null;
    }

    public abstract boolean canPark(Vehicle vehicle);
}
