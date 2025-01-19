package org.vikram.problems.parkinglot;

import java.util.HashMap;
import java.util.Optional;
import java.util.Random;

public class ParkingLot {
    private final HashMap<Integer, ParkingLotFloor> parkingLotFloors; // floor number -> floor
    private final HashMap<String, ParkingTicket> parkingTickets; // ticket id -> parking ticket

    private final ParkingStrategy parkingStrategy;

    private ParkingLot(int id, ParkingStrategy parkingStrategy){
        this.parkingLotFloors = new HashMap<>();
        this.parkingTickets = new HashMap<>();
        this.parkingStrategy = parkingStrategy;
    }

    private static final class ParkingLotHolder{
        private static final ParkingLot parkingLot = new ParkingLot(new Random().nextInt(), new FirstAvailableStrategy());
    }

    public static ParkingLot getParkingLot(){
        return ParkingLotHolder.parkingLot;
    }

    public void addFloor(int floorNumber, int totalSlots){
        ParkingLotFloor parkingLotFloor = new ParkingLotFloor(floorNumber, totalSlots);
        parkingLotFloors.put(floorNumber, parkingLotFloor);
    }

    /*
        Returns parking ticket number
     */
    public String parkVehicle(Vehicle vehicle, int floorNumber) throws Exception {
        if(!parkingLotFloors.containsKey(floorNumber)){
            throw new Exception("Invalid floor number");
        }

        ParkingLotFloor parkingLotFloor = parkingLotFloors.get(floorNumber);
        Optional<ParkingSlot> availableSpot = parkingStrategy.findAvailableSpot(vehicle, parkingLotFloor);

        if(availableSpot.isEmpty()){
            throw new Exception("No available spot found");
        }else{
            ParkingSlot parkingSlot = availableSpot.get();
            ParkingTicket parkingTicket = parkingSlot.parkVehicle(vehicle);

            parkingTickets.put(parkingTicket.getTicketId(), parkingTicket);

            System.out.println("Vehicle with number: "+vehicle.getVehicleNumber()+" parked at floor "+floorNumber+" at parking slot "+parkingSlot.getId());

            return parkingTicket.getTicketId();
        }
    }

    /*
        Unpark vehicle
     */
    public void unparkVehicle(String ticketNumber){
        if(!parkingTickets.containsKey(ticketNumber)) {
            System.out.println("Invalid parking ticket");
        }

        String[] ticketParts = ticketNumber.split("_");

        int floorNumber = Integer.parseInt(ticketParts[0]);
        int parkingSlotId = Integer.parseInt(ticketParts[1]);
        long timestamp = Long.parseLong(ticketParts[3]);

        ParkingLotFloor parkingLotFloor = parkingLotFloors.get(floorNumber);
        ParkingSlot parkingSlot = parkingLotFloor.getParkingSlot(parkingSlotId);

        parkingSlot.unparkVehicle();
        parkingTickets.remove(ticketNumber);
    }
}
