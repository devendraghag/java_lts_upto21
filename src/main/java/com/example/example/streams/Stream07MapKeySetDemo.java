package com.example.streams;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Demonstrates streaming keys and looking up each key's value. */
public class Stream07MapKeySetDemo {
    public static void main(String[] args) {
        // LinkedHashMap keeps insertion order when its keys are traversed.
        Map<String, Integer> stockByProduct = new LinkedHashMap<>();
        stockByProduct.put("Keyboard", 8);
        stockByProduct.put("Monitor", 0);
        stockByProduct.put("Mouse", 14);
        stockByProduct.put("Webcam", 3);

        // keySet() is useful when the stream primarily needs keys.
        List<String> productsInStock = stockByProduct.keySet().stream()
                // The lambda receives a key, so use the map to inspect its value.
                .filter(product -> stockByProduct.get(product) > 0)
                .map(product -> product + " (quantity: " + stockByProduct.get(product) + ")")
                .toList();

        System.out.println("Available products: " + productsInStock);
    }
}