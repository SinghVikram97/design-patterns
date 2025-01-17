package org.vikram.strategypattern;

interface PaymentStrategy{
    void pay(double amount);
}

class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paying using credit card");
    }
}

class PaypalPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paying using paypal");
    }
}

class ShoppingCart{
    private double amount;

    public void addAmount(double amount){
        this.amount = this.amount+amount;
    }
    public void checkout(PaymentStrategy paymentStrategy){
       paymentStrategy.pay(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addAmount(100);
        cart.addAmount(500);

        cart.checkout(new CreditCardPaymentStrategy());
    }
}