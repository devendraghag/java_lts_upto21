package com.example.designpattern.structural;

// Object Adapter: wrap a legacy API and translate the interface expected by the client.
public class Adapter01ObjectAdapterDemo {
    interface PaymentProcessor { void pay(double amount); }

    static class LegacyWallet {
        void makePaymentInRupees(double rupees) {
            System.out.println("Legacy wallet charged Rs " + rupees);
        }
    }

    static class WalletAdapter implements PaymentProcessor {
        private final LegacyWallet wallet; // Composition keeps the adapter flexible.
        WalletAdapter(LegacyWallet wallet) { this.wallet = wallet; }
        public void pay(double amount) { wallet.makePaymentInRupees(amount); }
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new WalletAdapter(new LegacyWallet());
        processor.pay(250.0);
    }
}
