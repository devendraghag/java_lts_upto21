package com.example.coupling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Common coupling: multiple classes read or change the same global mutable data.
 * Shared state makes behavior harder to trace; prefer passing needed values.
 */
public class CouplingType05Common {
    static class SharedConfiguration {
        static double taxRate = 0.10;
    }

    static class TaxCalculator {
        double calculate(double amount) {
            return amount * SharedConfiguration.taxRate;
        }
    }

    static class SettingsScreen {
        void changeTaxRate(double newRate) {
            SharedConfiguration.taxRate = newRate;
        }
    }

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator();
        System.out.println("Tax before settings change: " + calculator.calculate(100));

        new SettingsScreen().changeTaxRate(0.20);
        System.out.println("Tax after settings change: " + calculator.calculate(100));
    }
}
