package com.example.terminaloperations;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/** Medium: min and max use a Comparator and return Optional for empty-stream safety. */
public class TerminalOperationPractice06MinMax {
    record Product(String name, double price) {
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Keyboard", 49.99),
                new Product("Monitor", 199.99),
                new Product("Mouse", 24.50));
        Comparator<Product> byPrice = Comparator.comparingDouble(Product::price);

        Optional<Product> cheapest = products.stream().min(byPrice);
        Optional<Product> mostExpensive = products.stream().max(byPrice);

        System.out.println("Cheapest: " + cheapest.orElse(null));
        System.out.println("Most expensive: " + mostExpensive.orElse(null));
        System.out.println("Empty input min: " + List.<Product>of().stream().min(byPrice));
    }
}
