package com.example.example.interviewprograms.p53_stream_map_entries;

import java.util.LinkedHashMap;
import java.util.Map;

/** Additional example: Filter and Sort Map Entries. Java 8+ standalone example. */
public class StreamMapEntries {
    public static void main(String[] args) {
        Map<String, Integer> stockByProduct = new LinkedHashMap<>();
        stockByProduct.put("Keyboard", 12);
        stockByProduct.put("Laptop", 4);
        stockByProduct.put("Monitor", 0);
        stockByProduct.put("Mouse", 25);
        stockByProduct.put("Webcam", 3);

        stockByProduct.entrySet().stream()
                .filter(entry -> entry.getValue() <= 5)
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparing(entry -> entry.getKey()))
                .forEach(entry -> System.out.println(
                        entry.getKey() + " has " + entry.getValue() + " items"));
    }
}