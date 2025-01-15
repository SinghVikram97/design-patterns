package org.vikram.mediatorpattern;

import java.util.ArrayList;
import java.util.List;

interface Colleague{
    void placeBid(int amount); // action
    void getBidNotification(Colleague bidder, int amount); // receive notification via mediator
    String getName();
}

interface Mediator{
    void addBidder(Colleague bidder);
    void placeBid(Colleague bidder, int amount); // action
}

class Bidder implements Colleague{
    private final Mediator mediator;
    private final String name;

    public Bidder(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    @Override
    public void placeBid(int amount) {
        mediator.placeBid(this, amount);
    }

    @Override
    public void getBidNotification(Colleague bidder, int amount) {
        System.out.println("Notification to "+this.getName()+" Bid of amount "+amount+ " placed by "+bidder.getName());
    }

    public String getName() {
        return name;
    }
}

class AuctionMediator implements Mediator{
    private final List<Colleague> bidderList;

    AuctionMediator() {
        this.bidderList = new ArrayList<>();
    }

    @Override
    public void addBidder(Colleague bidder) {
        bidderList.add(bidder);
    }

    @Override
    public void placeBid(Colleague placingBidder, int amount) {
        bidderList.forEach(bidder -> {
            if(!bidder.getName().equals(placingBidder.getName())){
                bidder.getBidNotification(placingBidder, amount);
            }
        });
    }
}

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new AuctionMediator();

        Colleague bidder1 = new Bidder(auctionMediator, "A");
        Colleague bidder2 = new Bidder(auctionMediator, "B");
        Colleague bidder3 = new Bidder(auctionMediator, "C");

        auctionMediator.addBidder(bidder1);
        auctionMediator.addBidder(bidder2);
        auctionMediator.addBidder(bidder3);

        bidder1.placeBid(20);

        System.out.println("------------");

        bidder2.placeBid(100);
    }
}
