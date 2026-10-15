package com.example.comparable;

import java.util.*;

public class Comparable06ProductByPrice {
    record Product(String name, int price) implements Comparable<Product> {
        public int compareTo(Product o) {
            return Integer.compare(price, o.price);
        }
    }

    public static void main(String[] x) {
        List<Product> products = List.of(
                new Product("Keyboard", 2500),
                new Product("Mouse", 900));
        System.out.println(products.stream()
                .sorted()
                .toList());
    }
}
