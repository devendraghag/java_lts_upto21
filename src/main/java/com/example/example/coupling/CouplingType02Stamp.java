package com.example.coupling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Stamp coupling: a whole data object is passed, although the method uses only
 * one part of it. Passing a smaller value could reduce the dependency.
 */
public class CouplingType02Stamp {
    static class Customer {
        private final String name;
        private final String postalCode;
        private final String phoneNumber;

        Customer(String name, String postalCode, String phoneNumber) {
            this.name = name;
            this.postalCode = postalCode;
            this.phoneNumber = phoneNumber;
        }

        String getPostalCode() {
            return postalCode;
        }
    }

    static class ShippingQuoteService {
        double quote(Customer customer) {
            // The service receives name and phone too, but only uses postalCode.
            return customer.getPostalCode().startsWith("9") ? 12.0 : 8.0;
        }
    }

    public static void main(String[] args) {
        Customer customer = new Customer("Ava", "90210", "555-0100");
        System.out.println("Shipping quote: " + new ShippingQuoteService().quote(customer));
    }
}
