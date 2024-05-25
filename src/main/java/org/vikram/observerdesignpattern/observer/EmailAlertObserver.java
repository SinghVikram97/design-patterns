package org.vikram.observerdesignpattern.observer;

import org.vikram.observerdesignpattern.observerable.IphoneObservable;
import org.vikram.observerdesignpattern.observerable.StockObservable;

public class EmailAlertObserver implements NotificationAlertObserver{
    private final String emailId;
    private final IphoneObservable stockObservable;

    public EmailAlertObserver(String emailId, IphoneObservable stockObservable) {
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail();
    }

    private void sendEmail() {
        System.out.println("Email sent to email id: "+this.emailId+" new stock is: "+stockObservable.getCount());
    }
}
