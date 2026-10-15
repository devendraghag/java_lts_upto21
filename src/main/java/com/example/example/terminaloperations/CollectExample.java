package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Demonstrates multiple unique ways to use Stream.collect()
 * Compatible with Java 8 through Java 21
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class CollectExample {

    public static void main(String[] args) {
        basicCollectToList();
        collectToSet();
        collectWithFilter();
        collectWithMapping();
        collectToMap();
        collectGroupingBy();
        collectJoining();
        collectUnmodifiable();
    }

    // ---------------------------------------------------------
    // 1. BASIC collect() to List
    // ---------------------------------------------------------
    static void basicCollectToList() {
        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
        // collect() transforms stream back into a List
        List<String> result = names.stream().collect(Collectors.toList());
        System.out.println("1. Basic collect to List: " + result);
    }

    // ---------------------------------------------------------
    // 2. collect() to Set (Removes duplicates)
    // ---------------------------------------------------------
    static void collectToSet() {
        List<String> names = Arrays.asList("Bob", "Bob", "Charlie");
        // Set automatically removes duplicates
        Set<String> uniqueNames = names.stream().collect(Collectors.toSet());
        System.out.println("2. Collect to Set (unique): " + uniqueNames);
    }

    // ---------------------------------------------------------
    // 3. collect() with filter (Your original example, corrected)
    // ---------------------------------------------------------
    static void collectWithFilter() {
        List<String> names = Arrays.asList("Bob", "Bob", "Charlie");
        // Filter names with length > 2, then collect into a List
        List<String> filtered =names.stream().filter(name -> name.length() > 2).collect(Collectors.toList());
        System.out.println("3. Filter + collect: " + filtered);
    }

    // ---------------------------------------------------------
    // 4. collect() with map (Transform elements)
    // ---------------------------------------------------------
    static void collectWithMapping() {
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        // map() transforms each element before collecting
        List<String> upperCaseNames =
                names.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());
        System.out.println("4. Map + collect: " + upperCaseNames);
    }

    // ---------------------------------------------------------
    // 5. collect() to Map (Key–Value pairs)
    // ---------------------------------------------------------
    static void collectToMap() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // Converts List into Map<name, length>
        Map<String, Integer> nameLengthMap =
                names.stream()
                        .collect(Collectors.toMap(
                                name -> name,          // key
                                name -> name.length()  // value
                        ));
        System.out.println("5. Collect to Map: " + nameLengthMap);
    }

    // ---------------------------------------------------------
    // 6. collect() with groupingBy (Very common in real projects)
    // ---------------------------------------------------------
    static void collectGroupingBy() {
        List<String> names = Arrays.asList("Anna", "Bob", "Alice", "Brian");
        // Groups names by first character
        Map<Character, List<String>> grouped = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println("6. GroupingBy: " + grouped);
    }

    // ---------------------------------------------------------
    // 7. collect() with joining (Strings only)
    // ---------------------------------------------------------
    static void collectJoining() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // Joins elements into a single String
        String joined = names.stream().collect(Collectors.joining(", "));
        System.out.println("7. Joining: " + joined);
    }

    // ---------------------------------------------------------
    // 8. collect() to Unmodifiable List (JDK 10+)
    // ---------------------------------------------------------
    static void collectUnmodifiable() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        // Creates an immutable List
        List<String> unmodifiable = names.stream().collect(Collectors.toUnmodifiableList());
        System.out.println("8. Unmodifiable List: " + unmodifiable);
        // unmodifiable.add("David"); // ❌ throws UnsupportedOperationException
    }
}