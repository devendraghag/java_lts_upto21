package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Demonstrates collecting stream elements into a Map using Collectors.toMap()
 * Covers common, safe, and interview-important variations
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class CollectToMapExample {

    public static void main(String[] args) {

        basicToMap();
        toMapWithMergeFunction();
        toMapWithCustomMap();
        toMapAfterFiltering();
        toMapAfterMapping();
        groupingAlternative();
        unmodifiableMapExample();
    }

    // ---------------------------------------------------------
    // 1. BASIC toMap() – Unique keys only
    // ---------------------------------------------------------
    static void basicToMap() {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // Key = string length, Value = string itself
        Map<Integer, String> map =
                fruits.stream()
                        .collect(Collectors.toMap(
                                String::length,
                                s -> s
                        ));

        System.out.println("1. Basic toMap: " + map);
    }

    // ---------------------------------------------------------
    // 2. toMap() with MERGE FUNCTION (Your original example)
    // ---------------------------------------------------------
    static void toMapWithMergeFunction() {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // When duplicate keys occur, old value is retained
        Map<Integer, String> map =
                fruits.stream()
                        .collect(Collectors.toMap(
                                String::length,      // key
                                s -> s,              // value
                                (oldVal, newVal) -> oldVal // merge strategy
                        ));

        System.out.println("2. toMap with merge function: " + map);
    }

    // ---------------------------------------------------------
    // 3. toMap() with CUSTOM MAP implementation
    // ---------------------------------------------------------
    static void toMapWithCustomMap() {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // Uses LinkedHashMap to preserve insertion order
        Map<Integer, String> map =
                fruits.stream()
                        .collect(Collectors.toMap(
                                String::length,
                                s -> s,
                                (a, b) -> a,
                                LinkedHashMap::new
                        ));

        System.out.println("3. toMap with LinkedHashMap: " + map);
    }

    // ---------------------------------------------------------
    // 4. toMap() AFTER filter() (Conditional mapping)
    // ---------------------------------------------------------
    static void toMapAfterFiltering() {

        List<String> fruits = Arrays.asList("Apple", "Kiwi", "Banana");

        // Only strings with length > 4 are collected
        Map<Integer, String> map =
                fruits.stream()
                        .filter(s -> s.length() > 4)
                        .collect(Collectors.toMap(
                                String::length,
                                s -> s
                        ));

        System.out.println("4. Filter + toMap: " + map);
    }

    // ---------------------------------------------------------
    // 5. toMap() AFTER map() (Transform before mapping)
    // ---------------------------------------------------------
    static void toMapAfterMapping() {

        List<String> fruits = Arrays.asList("apple", "banana", "cherry");

        // Convert to uppercase before collecting
        Map<Integer, String> map =
                fruits.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toMap(
                                String::length,
                                s -> s
                        ));

        System.out.println("5. Map + toMap: " + map);
    }

    // ---------------------------------------------------------
    // 6. groupingBy() as SAFE alternative to toMap()
    // ---------------------------------------------------------
    static void groupingAlternative() {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // groupingBy handles duplicate keys automatically
        Map<Integer, List<String>> map =
                fruits.stream()
                        .collect(Collectors.groupingBy(String::length));

        System.out.println("6. groupingBy alternative: " + map);
    }

    // ---------------------------------------------------------
    // 7. Unmodifiable Map (JDK 10+)
    // ---------------------------------------------------------
    static void unmodifiableMapExample() {

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");

        // Creates an immutable Map
        Map<Integer, String> map =
                fruits.stream()
                        .collect(Collectors.toUnmodifiableMap(
                                String::length,
                                s -> s,
                                (a, b) -> a
                        ));

        System.out.println("7. Unmodifiable Map: " + map);

        // map.put(5, "Grapes"); // ❌ UnsupportedOperationException
    }
}
