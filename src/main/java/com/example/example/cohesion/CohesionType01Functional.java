package com.example.cohesion;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Functional cohesion: all methods in this class help calculate one result,
 * the final invoice total.
 *
 * Cohesion describes how closely a class's responsibilities fit together;
 * it is separate from abstract-class inheritance. See AbstractClass01Declaration.java
 * for an abstract-class example.
 */
public class CohesionType01Functional {
    static class InvoiceTotalCalculator {
        double calculate(double subtotal, double taxRate) {
            double tax = calculateTax(subtotal, taxRate);
            return addTax(subtotal, tax);
        }

        private double calculateTax(double subtotal, double taxRate) {
            return subtotal * taxRate;
        }

        private double addTax(double subtotal, double tax) {
            return subtotal + tax;
        }
    }

    public static void main(String[] args) {
        double total = new InvoiceTotalCalculator().calculate(100.0, 0.10);
        System.out.println("Invoice total with 10% tax: " + total);
    }
}