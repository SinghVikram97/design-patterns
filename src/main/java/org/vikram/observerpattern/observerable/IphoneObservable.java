package org.vikram.observerpattern.observerable;

import org.vikram.observerpattern.observer.NotificationAlertObserver;
import org.vikram.observerpattern.stockkeeper.StockKeeper;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements StockObservable, StockKeeper {
    private final List<NotificationAlertObserver> observerList = new ArrayList<>();
    private int stockCount = 0;
    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {
        observerList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {
        observerList.remove(notificationAlertObserver);
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(NotificationAlertObserver::update);
    }

    @Override
    public void setCount(int newStockAdded) {
        if(stockCount==0){
            stockCount+=newStockAdded;
            notifyObservers();
        }else{
            stockCount+=newStockAdded;
        }
    }

    @Override
    public int getCount() {
        return stockCount;
    }

}
