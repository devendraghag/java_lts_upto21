package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator55StreamLimitSkip {
    record Product(String name, int price) {}

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Pen", 2),
                new Product("Desk", 100),
                new Product("Book", 20),
                new Product("Cup", 5));
        Comparator<Product> byPrice = Comparator.comparingInt(Product::price);

        System.out.println("cheapest two = " + products.stream().sorted(byPrice).limit(2).toList());
        System.out.println("skip cheapest two = "
                + products.stream().sorted(byPrice).skip(2).toList());
    }
}
