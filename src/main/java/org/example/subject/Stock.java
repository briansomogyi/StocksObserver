package org.example.subject;

import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * The Stock (Observable).
 * Keeps track of observers and notifies them of state changes.
 */
public abstract class Stock {
    // Java Standard: camelCase fields, private visibility
    private final String name;
    private final String currency;
    private double price;

    // List to hold all subscribed investors
    private final List<Observer> subscribers = new ArrayList<>();

    protected Stock(String name, String currency, double price) {
        this.name = name;
        this.currency = currency;
        this.price = price;
    }

    /**
     * Adds an observer to the list.
     */
    public void subscribe(Observer observer) {
        if (!subscribers.contains(observer)) {
            subscribers.add(observer);
            System.out.println("[System] " + observer + " subscribed to " + this.name);
        }
    }

    /**
     * Removes an observer from the list.
     */
    public void unsubscribe(Observer observer) {
        if (subscribers.remove(observer)) {
            System.out.println("[System] " + observer + " unsubscribed from " + this.name);
        }
    }

    /**
     * The "Notification" mechanism.
     * Iterates through all subscribers and calls their update method.
     */
    protected void notifySubscribers() {
        for (Observer observer : subscribers) {
            // We pass 'this' to give the observer context (Push-Reference)
            observer.update(this);
        }
    }

    // --- Getters and Setters ---

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    /**
     * Updates price and triggers notification.
     */
    public void setPrice(double price) {
        // Only notify if the price ACTUALLY changed to avoid spam
        if (this.price != price) {
            this.price = price;
            notifySubscribers();
        }
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return name + " (" + price + " " + currency + ")";
    }
}