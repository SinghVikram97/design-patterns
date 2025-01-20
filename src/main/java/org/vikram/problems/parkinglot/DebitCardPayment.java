package org.vikram.problems.parkinglot;

public class DebitCardPayment implements PaymentStrategy{
    private final String cardNumber;
    private final String pin;

    public DebitCardPayment(String cardNumber, String pin) {
        this.cardNumber = cardNumber;
        this.pin = pin;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying amount "+amount+" using debit card");
    }
}
