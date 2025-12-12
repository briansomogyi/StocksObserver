package org.example.factory;

import org.example.investors.PrivateInvestor;
import org.example.investors.PublicInvestor;
import org.example.observer.Observer;

/**
 * Factory Pattern.
 * Centralizes the creation of investors.
 * If we need to add "CryptoInvestor" later, we only change code here, not in Main.
 */
public class InvestorFactory {

    // Using an Enum for types is safer than raw strings
    public enum InvestorType {
        PRIVATE, PUBLIC
    }

    public static Observer createInvestor(InvestorType type, String name) {
        return switch (type) {
            case PRIVATE -> new PrivateInvestor(name);
            case PUBLIC -> new PublicInvestor(name);
        };
    }
}