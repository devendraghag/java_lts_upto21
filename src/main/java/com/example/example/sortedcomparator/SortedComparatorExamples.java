package com.example.sortedcomparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Demonstrates Stream.sorted(Comparator) and common comparator techniques through JDK 21.
 * No preview or incubator APIs are used.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/sortedcomparator/SortedComparatorExamples.java
 *   java -cp out com.example.sortedcomparator.SortedComparatorExamples
 */
public class SortedComparatorExamples {
    public static void main(String[] args) {
        naturalAndCustomOrder();
        sortByProperties();
        chainedComparators();
        reverseOrder();
        nullFriendlyComparators();
    }

    private static void naturalAndCustomOrder() {
        System.out.println("== Natural order and sorted(Comparator) ==");
        List<String> words = List.of("pear", "Apple", "fig", "banana");
        System.out.println("sorted() natural order: " + words.stream().sorted().toList());
        System.out.println("case-insensitive: " + words.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER).toList());

        Comparator<String> byLengthThenText = Comparator.comparingInt(String::length)
                .thenComparing(String.CASE_INSENSITIVE_ORDER);
        System.out.println("length, then text: " + words.stream().sorted(byLengthThenText).toList());
    }

    private static void sortByProperties() {
        System.out.println("\n== Sort objects by a selected property ==");
        System.out.println("price ascending: " + products().stream()
                .sorted(Comparator.comparingInt(Product::price)).toList());
        System.out.println("name ascending: " + products().stream()
                .sorted(Comparator.comparing(Product::name)).toList());
        // comparingInt/Long/Double avoid boxing primitive sort keys.
    }

    private static void chainedComparators() {
        System.out.println("\n== thenComparing tie-breakers ==");
        Comparator<Product> byCategoryPriceName = Comparator.comparing(Product::category)
                .thenComparingInt(Product::price)
                .thenComparing(Product::name);
        System.out.println("category, price, name: " + products().stream().sorted(byCategoryPriceName).toList());

        Comparator<Product> ratingDescendingPriceAscending = Comparator
                .comparingInt(Product::rating).reversed()
                .thenComparingInt(Product::price);
        System.out.println("rating descending, then price ascending: "
                + products().stream().sorted(ratingDescendingPriceAscending).toList());
    }

    private static void reverseOrder() {
        System.out.println("\n== Reverse ordering ==");
        List<Integer> numbers = List.of(7, 2, 9, 2, 5);
        System.out.println("ascending: " + numbers.stream().sorted().toList());
        System.out.println("descending: " + numbers.stream().sorted(Comparator.reverseOrder()).toList());
        System.out.println("price descending: " + products().stream()
                .sorted(Comparator.comparingInt(Product::price).reversed()).toList());
    }

    private static void nullFriendlyComparators() {
        System.out.println("\n== Null-friendly comparators ==");
        List<String> values = Arrays.asList("pear", null, "Apple", null, "fig");
        Comparator<String> nullsLast = Comparator.nullsLast(String.CASE_INSENSITIVE_ORDER);
        System.out.println("nulls last: " + values.stream().sorted(nullsLast).toList());

        Comparator<String> nullsFirstByLength = Comparator.nullsFirst(Comparator.comparingInt(String::length));
        System.out.println("nulls first, then length: " + values.stream().sorted(nullsFirstByLength).toList());
    }

    private static List<Product> products() {
        return List.of(
                new Product("Keyboard", "Accessories", 80, 4),
                new Product("Mouse", "Accessories", 35, 5),
                new Product("Monitor", "Displays", 240, 5),
                new Product("Portable Monitor", "Displays", 180, 4),
                new Product("Headset", "Accessories", 80, 5));
    }

    private record Product(String name, String category, int price, int rating) { }
}
