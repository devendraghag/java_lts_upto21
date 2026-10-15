package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator14MethodReferenceProductPrice {
    record Product(String name, double price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Desk", 250.0), new Product("Lamp", 30.0));
        // Product::price supplies a double key to comparingDouble.
        System.out.println(products.stream()
                .sorted(Comparator.comparingDouble(Product::price)).toList());
    }
}
