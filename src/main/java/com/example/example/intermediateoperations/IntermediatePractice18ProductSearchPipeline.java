package com.example.intermediateoperations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** Challenge: filter, order, page, map, then use a collector to format the result. */
public class IntermediatePractice18ProductSearchPipeline {
    record Product(String name, String category, double price, boolean available) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Keyboard", "Electronics", 49.99, true),
                new Product("Monitor", "Electronics", 199.99, true),
                new Product("Mouse", "Electronics", 24.50, true),
                new Product("Desk", "Furniture", 249.00, true),
                new Product("Webcam", "Electronics", 79.00, false));
        String names = products.stream()
                .filter(Product::available)
                .filter(product -> product.category().equals("Electronics"))
                .sorted(Comparator.comparingDouble(Product::price))
                .skip(1)
                .limit(2)
                .map(Product::name)
                .collect(Collectors.joining(", "));
        System.out.println("Next products by price: " + names);
    }
}