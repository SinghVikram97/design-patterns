package org.vikram.observerdesignpattern;

import org.vikram.observerdesignpattern.observer.EmailAlertObserver;
import org.vikram.observerdesignpattern.observer.MobileAlertObserver;
import org.vikram.observerdesignpattern.observer.NotificationAlertObserver;
import org.vikram.observerdesignpattern.observerable.IphoneObservable;
import org.vikram.observerdesignpattern.observerable.StockObservable;

public class Main {
    public static void main(String[] args) {
        IphoneObservable iphoneObservable = new IphoneObservable();

        NotificationAlertObserver observer1 = new EmailAlertObserver("vikram.bedi97@gmail.com", iphoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserver("vikram.bedi97@gmail.com", iphoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserver("9650498659", iphoneObservable);

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setCount(10);
    }
}
