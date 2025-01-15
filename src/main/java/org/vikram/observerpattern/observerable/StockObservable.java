package org.vikram.observerpattern.observerable;

import org.vikram.observerpattern.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);

    public void remove(NotificationAlertObserver notificationAlertObserver);

    public void notifyObservers();
}
