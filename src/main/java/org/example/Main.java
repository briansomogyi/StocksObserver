package org.example;

import org.example.factory.InvestorFactory;
import org.example.observer.Observer;
import org.example.subject.AmazonStock;
import org.example.subject.Stock;

public class Main {
    public static void main(String[] args) {
        // 1. Create the Subject
        Stock amzStock = new AmazonStock("$", 1000);
        System.out.println("--- Market Open: " + amzStock + " ---");

        // 2. Create Observers using FACTORY (Clean creation)
        Observer johnDoe = InvestorFactory.createInvestor(InvestorFactory.InvestorType.PRIVATE, "John Doe");
        Observer vooEtf = InvestorFactory.createInvestor(InvestorFactory.InvestorType.PUBLIC, "VOO ETF");

        // 3. Register Observers (Explicit subscription - much better dependency management)
        amzStock.subscribe(johnDoe);
        amzStock.subscribe(vooEtf);

        System.out.println("\n--- Trading Session Starts ---");

        // 4. Change State -> Triggers 'update(Stock s)'
        System.out.println("\n[Action] Price increases to 1050");
        amzStock.setPrice(1050);

        // 5. Dynamic Unsubscription
        System.out.println("\n[Action] John Doe leaves the market");
        amzStock.unsubscribe(johnDoe);

        // 6. Change State again
        System.out.println("\n[Action] Price drops to 900");
        amzStock.setPrice(900);
        // Only VOO receives this, proving the pattern works dynamically.

        System.out.println("\n--- Market Closed ---");
    }
}