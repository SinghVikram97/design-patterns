package org.vikram.problems.parkinglot;

public class UnparkVehicleImp implements UnparkVehicleCommand{
    private final ParkingLot parkingLot;

    public UnparkVehicleImp(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void unparkVehicle(String ticketNumber, PaymentStrategy paymentStrategy) throws Exception {
        parkingLot.checkParkingTicket(ticketNumber);
        String[] ticketParts = ticketNumber.split("_");

        int floorNumber = Integer.parseInt(ticketParts[0]);
        int parkingSlotId = Integer.parseInt(ticketParts[1]);
        long timestamp = Long.parseLong(ticketParts[3]);

        ParkingLotFloor parkingLotFloor = parkingLot.getParkingLotFloor(floorNumber);
        ParkingSlot parkingSlot = parkingLotFloor.getParkingSlot(parkingSlotId);

        // Calculate amount based on timestamp and current time
        paymentStrategy.pay(1000.20);
        parkingSlot.unparkVehicle();
        parkingLot.removeParkingTicket(ticketNumber);
    }
}
