package com.example.composition;

/** Immutable Money values are created as part of and owned by each Wallet. */
public class Composition03ImmutableValueObject {
    public static void main(String[] args) {
        Wallet wallet = new Wallet("USD", 25, 75);
        wallet.printBalance();
    }
    private static final class Wallet {
        private final Money balance;
        private Wallet(String currency, long units, int cents) {
            this.balance = new Money(currency, units, cents);
        }
        private void printBalance() { System.out.println("Balance: " + balance); }
    }
    private static final class Money {
        private final String currency;
        private final long cents;
        private Money(String currency, long units, int cents) {
            this.currency = currency;
            this.cents = Math.addExact(Math.multiplyExact(units, 100), cents);
        }
        @Override public String toString() { return currency + " " + cents / 100 + "." + String.format("%02d", cents % 100); }
    }
}
