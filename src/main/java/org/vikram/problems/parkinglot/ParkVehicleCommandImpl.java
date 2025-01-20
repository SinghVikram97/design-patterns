package org.vikram.problems.parkinglot;

import java.util.Optional;

public class ParkVehicleCommandImpl implements ParkVehicleCommand{
    private final ParkingStrategy parkingStrategy;
    private final ParkingLot parkingLot;

    public ParkVehicleCommandImpl(ParkingStrategy parkingStrategy, ParkingLot parkingLot) {
        this.parkingStrategy = parkingStrategy;
        this.parkingLot = parkingLot;
    }

    @Override
    public String parkVehicle(Vehicle vehicle, int floorNumber) throws Exception {
        ParkingLotFloor parkingLotFloor = parkingLot.getParkingLotFloor(floorNumber);
        Optional<ParkingSlot> availableSpot = parkingStrategy.findAvailableSpot(vehicle, parkingLotFloor);

        if(availableSpot.isEmpty()){
            throw new Exception("No available spot found");
        }else{
            ParkingSlot parkingSlot = availableSpot.get();
            ParkingTicket parkingTicket = parkingSlot.parkVehicle(vehicle);

            System.out.println("Vehicle with number: "+vehicle.getVehicleNumber()+" parked at floor "+parkingLotFloor.getFloorNumber()+" at parking slot "+parkingSlot.getId());

            parkingLot.addParkingTicket(parkingTicket.getTicketId());

            return parkingTicket.getTicketId();
        }
    }
}
