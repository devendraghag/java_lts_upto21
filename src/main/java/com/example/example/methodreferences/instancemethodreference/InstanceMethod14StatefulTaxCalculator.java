package com.example.methodreferences.instancemethodreference;

import java.util.function.Function;

/** Hard: the reference keeps the specific calculator instance and its configured tax rate. */
public class InstanceMethod14StatefulTaxCalculator {
    static class TaxCalculator {
        private final double rate;

        TaxCalculator(double rate) {
            this.rate = rate;
        }

        double addTax(double price) {
            return price * (1.0 + rate);
        }
    }

    public static void main(String[] args) {
        TaxCalculator calculator = new TaxCalculator(0.18);
        Function<Double, Double> lambda = price -> calculator.addTax(price);
        Function<Double, Double> reference = calculator::addTax;

        System.out.printf("Lambda total: %.2f%n", lambda.apply(100.0));
        System.out.printf("Reference total: %.2f%n", reference.apply(250.0));
    }
}
