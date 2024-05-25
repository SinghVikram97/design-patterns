package org.vikram.observerdesignpattern.observerable;

import org.vikram.observerdesignpattern.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver notificationAlertObserver);

    public void remove(NotificationAlertObserver notificationAlertObserver);

    public void notifyObservers();
}
