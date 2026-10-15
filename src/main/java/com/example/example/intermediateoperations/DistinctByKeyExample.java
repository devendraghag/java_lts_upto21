package com.example.intermediateoperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Demonstrates DISTINCT BY KEY techniques.
 * Shows stateful predicates, safe parallel alternatives,
 * and collector-based solutions.
 *
 * IMPORTANT:
 * - Some approaches are NOT safe for parallel streams
 * - Know when to use each
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DistinctByKeyExample {

    public static void main(String[] args) {

        basicStatefulPredicate();
        distinctByKeyReusableMethod();
        parallelSafeDistinct();
        distinctUsingCollector();
        distinctUsingGroupingBy();
        distinctUsingTreeSet();
        explanation();
    }

    // ---------------------------------------------------------
    // 1. BASIC stateful predicate (Your original idea)
    // ---------------------------------------------------------
    static void basicStatefulPredicate() {

        List<String> list = Arrays.asList("apple", "ant", "banana", "ball");

        Set<Character> seen = new HashSet<>();

        // NOT parallel-safe
        list.stream()
                .filter(s -> seen.add(s.charAt(0)))
                .forEach(System.out::println);

        // Output:
        // apple
        // banana
    }

    // ---------------------------------------------------------
    // 2. Reusable distinctByKey() method (Your original example)
    // ---------------------------------------------------------
    static void distinctByKeyReusableMethod() {

        List<String> list = Arrays.asList("apple", "ant", "banana", "ball");

        list.stream()
                .filter(distinctByKey(s -> s.charAt(0)))
                .forEach(System.out::println);
    }

    /**
     * Returns a predicate that filters elements by a derived key.
     * Uses mutable state → NOT safe for parallel streams.
     */
    public static <T> Predicate<T> distinctByKey(Function<T, ?> keyExtractor) {
        Set<Object> seen = new HashSet<>();
        return t -> seen.add(keyExtractor.apply(t));
    }

    // ---------------------------------------------------------
    // 3. ✅ PARALLEL-SAFE distinctByKey()
    // ---------------------------------------------------------
    static void parallelSafeDistinct() {

        List<String> list = Arrays.asList("apple", "ant", "banana", "ball");

        list.parallelStream()
                .filter(distinctByKeyParallelSafe(s -> s.charAt(0)))
                .forEach(System.out::println);
    }

    /**
     * Thread-safe version using ConcurrentHashMap
     */
    public static <T> Predicate<T> distinctByKeyParallelSafe(Function<T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    // ---------------------------------------------------------
    // 4. DISTINCT BY KEY using COLLECTOR (BEST PRACTICE)
    // ---------------------------------------------------------
    static void distinctUsingCollector() {

        List<String> list = Arrays.asList("apple", "ant", "banana", "ball");

        List<String> result =
                list.stream()
                        .collect(Collectors.toMap(
                                s -> s.charAt(0),   // key
                                s -> s,             // value
                                (oldVal, newVal) -> oldVal // keep first
                        ))
                        .values()
                        .stream()
                        .toList();

        System.out.println("Collector-based distinct: " + result);
    }

    // ---------------------------------------------------------
    // 5. DISTINCT BY KEY using groupingBy()
    // ---------------------------------------------------------
    static void distinctUsingGroupingBy() {

        List<String> list = Arrays.asList("apple", "ant", "banana", "ball");

        List<String> result =
                list.stream()
                        .collect(Collectors.groupingBy(s -> s.charAt(0)))
                        .values()
                        .stream()
                        .map(group -> group.get(0)) // take first per group
                        .toList();

        System.out.println("GroupingBy distinct: " + result);
    }

    // ---------------------------------------------------------
    // 6. DISTINCT BY KEY using TreeSet (Comparator-based)
    // ---------------------------------------------------------
    static void distinctUsingTreeSet() {

        List<String> list = Arrays.asList("apple", "ant", "banana", "ball");

        List<String> result =
                list.stream()
                        .collect(Collectors.collectingAndThen(
                                Collectors.toCollection(() ->
                                        new TreeSet<>(Comparator.comparing(s -> s.charAt(0)))
                                ),
                                ArrayList::new
                        ));

        System.out.println("TreeSet distinct: " + result);
    }

    // ---------------------------------------------------------
    // 7. Explanation (Interview-ready)
    // ---------------------------------------------------------
    static void explanation() {

        System.out.println("""
                Key Points:
                - distinct() works on equals() + hashCode()
                - distinctByKey requires custom logic
                - Stateful predicates are NOT recommended in parallel streams
                - Collector-based solutions are safest and most readable
                - Use ConcurrentHashMap when parallel execution is required

                Interview Rule:
                Prefer COLLECTORS for distinct-by-key in production code
                """);
    }
}