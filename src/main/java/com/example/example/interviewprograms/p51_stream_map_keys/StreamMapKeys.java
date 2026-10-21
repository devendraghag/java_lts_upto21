package com.example.example.interviewprograms.p51_stream_map_keys;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/** Additional example: Stream Map Keys. Java 8+ standalone example. */
public class StreamMapKeys {
    public static void main(String[] args) {
        Map<String, Integer> stockByProduct = new TreeMap<>();
        stockByProduct.put("Keyboard", 12);
        stockByProduct.put("Laptop", 4);
        stockByProduct.put("Monitor", 0);
        stockByProduct.put("Mouse", 25);

        List<String> productNames = stockByProduct.keySet().stream()
                .filter(name -> name.startsWith("M"))
                .collect(Collectors.toList());

        System.out.println("Products starting with M: " + productNames);

    }
}
