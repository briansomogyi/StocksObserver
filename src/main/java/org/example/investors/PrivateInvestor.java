package org.example.investors;

import org.example.observer.Observer;
import org.example.subject.Stock;

public class PrivateInvestor implements Observer {
    private final String name;

    // FIX: Constructor does NOT take a Stock object anymore.
    // This decouples the Investor from the Stock.
    public PrivateInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(Stock stock) {
        // Implementation of (b): Uses the info passed (stock.getPrice())
        System.out.println("  -> [Private] " + name + " checked their portfolio: " + stock.getName() + " is now " + stock.getPrice() + stock.getCurrency());
    }

    @Override
    public String toString() {
        return name;
    }
}