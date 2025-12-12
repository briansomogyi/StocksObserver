package org.example.observer;

import org.example.subject.Stock;

/**
 * The Observer Interface.
 * Defines the contract for any object that wants to watch a Stock.
 */
public interface Observer {
    /**
     * Triggered when the Subject changes.
     * * @param stock The Subject object that changed.
     * - Passing the object (Push-Reference) allows the investor
     * to check specifically WHAT changed (Price? Currency?).
     */
    void update(Stock stock);
}