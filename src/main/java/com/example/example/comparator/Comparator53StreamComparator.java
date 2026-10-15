package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator53StreamComparator {
    record Product(String sku, int price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("SKU-C", 10),
                new Product("SKU-A", 30),
                new Product("SKU-B", 20));

        // The stream gets a one-off price ordering; Product itself has no natural order.
        Comparator<Product> byPrice = Comparator.comparingInt(Product::price);
        System.out.println("custom stream order = "
                + products.stream().sorted(byPrice).toList());
        System.out.println("source = " + products);
    }
}
