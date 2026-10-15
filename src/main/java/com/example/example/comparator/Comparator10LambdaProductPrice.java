package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator10LambdaProductPrice {
    record Product(String name, double price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Pen", 2.5), new Product("Book", 10.0), new Product("Cup", 4.0));
        Comparator<Product> priceAscending = (a, b) -> Double.compare(a.price(), b.price());
        System.out.println(products.stream().sorted(priceAscending).toList());
    }
}
