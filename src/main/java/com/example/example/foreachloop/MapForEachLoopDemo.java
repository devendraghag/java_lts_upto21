package com.example.foreachloop;

import java.util.LinkedHashMap;
import java.util.Map;

/** Demonstrates iterating a map through its entry, key, and value views. */
public class MapForEachLoopDemo {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new LinkedHashMap<>();
        inventory.put("Notebook", 12);
        inventory.put("Pen", 30);

        // Map itself is not Iterable; its views are Iterable.
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        for (String product : inventory.keySet()) {
            System.out.println("Product: " + product);
        }

        for (int quantity : inventory.values()) {
            System.out.println("Quantity: " + quantity);
        }
    }
}
