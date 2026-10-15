package com.example.comparable;

import java.util.List;

public class Comparable22StreamComparable {
    record Product(String sku, int price) implements Comparable<Product> {
        @Override
        public int compareTo(Product other) {
            return sku.compareTo(other.sku);
        }
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("SKU-C", 10),
                new Product("SKU-A", 30),
                new Product("SKU-B", 20));
        System.out.println("natural stream order = " + products.stream().sorted().toList());
        System.out.println("source = " + products);
    }
}
