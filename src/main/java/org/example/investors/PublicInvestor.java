package org.example.investors;

import org.example.observer.Observer;
import org.example.subject.Stock;

public class PublicInvestor implements Observer {
    private final String name;

    public PublicInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        // Implementation of (a): Just reacting to the notification.
        // But because we have the reference, we CAN implement logic if we want.
        System.out.println("  -> [Public ] " + name + " received a ticker update for " + stock.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}