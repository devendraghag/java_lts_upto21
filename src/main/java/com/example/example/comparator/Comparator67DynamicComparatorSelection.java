package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator67DynamicComparatorSelection {
    record Product(String name, int price, int stock) {}
    enum SortBy { NAME, PRICE, STOCK }

    private static Comparator<Product> comparatorFor(SortBy sortBy) {
        return switch (sortBy) {
            case NAME -> Comparator.comparing(Product::name);
            case PRICE -> Comparator.comparingInt(Product::price);
            case STOCK -> Comparator.comparingInt(Product::stock);
        };
    }

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("Pen", 2, 50),
                new Product("Book", 20, 10),
                new Product("Cup", 5, 30));
        SortBy requestedOrder = SortBy.PRICE;
        Comparator<Product> order = comparatorFor(requestedOrder);
        System.out.println(products.stream().sorted(order).toList());
    }
}
