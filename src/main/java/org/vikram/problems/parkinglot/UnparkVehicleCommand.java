package org.vikram.problems.parkinglot;

public interface UnparkVehicleCommand {
    public void unparkVehicle(String ticketNumber, PaymentStrategy paymentStrategy) throws Exception;
}
