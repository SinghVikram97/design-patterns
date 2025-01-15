package org.vikram.observerpattern;

import org.vikram.observerpattern.observer.EmailAlertObserver;
import org.vikram.observerpattern.observer.MobileAlertObserver;
import org.vikram.observerpattern.observer.NotificationAlertObserver;
import org.vikram.observerpattern.observerable.IphoneObservable;

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
