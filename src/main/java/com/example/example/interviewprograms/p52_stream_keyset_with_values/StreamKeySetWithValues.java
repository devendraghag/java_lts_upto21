package com.example.interviewprograms.p52_stream_keyset_with_values;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/** Additional example: Filter Map Keys Using Their Values. Java 8+ standalone example. */
public class StreamKeySetWithValues {
    public static void main(String[] args) {
        Map<String, Integer> stockByProduct = new TreeMap<>();
        stockByProduct.put("Keyboard", 12);
        stockByProduct.put("Laptop", 4);
        stockByProduct.put("Monitor", 0);
        stockByProduct.put("Mouse", 25);

        // keySet() provides keys; get(name) looks up each corresponding value.
        String lowStockProducts = stockByProduct.keySet().stream()
                .filter(name -> stockByProduct.get(name) <= 5)
                .collect(Collectors.joining(", "));

        System.out.println("Products with 5 or fewer items: " + lowStockProducts);
    }
}
