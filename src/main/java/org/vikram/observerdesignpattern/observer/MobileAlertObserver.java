package org.vikram.observerdesignpattern.observer;

import org.vikram.observerdesignpattern.observerable.IphoneObservable;

public class MobileAlertObserver implements NotificationAlertObserver{
    private final String phoneNo;
    private final IphoneObservable stockObservable;

    public MobileAlertObserver(String emailId, IphoneObservable stockObservable) {
        this.phoneNo = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendSms();
    }

    private void sendSms() {
        System.out.println("SMS sent to phone no: "+this.phoneNo+" new stock is: "+stockObservable.getCount());
    }
}
