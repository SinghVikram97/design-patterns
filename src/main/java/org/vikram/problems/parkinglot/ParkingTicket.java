package org.vikram.problems.parkinglot;

import java.util.Date;

public class ParkingTicket {
    private final String ticketId;

    public ParkingTicket(Vehicle vehicle, int floorNumber, int parkingSlotId) {
        this.ticketId = String.format("%d_%d_%s_%d", floorNumber, parkingSlotId, vehicle.getVehicleNumber(), new Date().getTime());
    }

    public String getTicketId() {
        return ticketId;
    }
}
