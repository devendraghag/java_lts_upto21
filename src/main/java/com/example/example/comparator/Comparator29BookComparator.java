package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator29BookComparator {
    record Book(String title, int edition, int price) {}

    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Java", 2, 50),
                new Book("Algorithms", 1, 80),
                new Book("Java", 1, 40));

        // This alternate requirement orders price high-to-low, then title; edition is a final tie-breaker.
        Comparator<Book> priceOrder = Comparator.comparingInt(Book::price)
                .reversed()
                .thenComparing(Book::title)
                .thenComparingInt(Book::edition);
        System.out.println(books.stream().sorted(priceOrder).toList());
    }
}
