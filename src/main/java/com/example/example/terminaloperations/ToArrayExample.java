package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Arrays;
import java.util.List;

/**
 * Demonstrates terminal operation toArray().
 * Converts stream elements into an array.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ToArrayExample {

    public static void main(String[] args) {

        basicToArray();
        typedToArray();
        toArrayAfterFilter();
        toArrayAfterMap();
        emptyStreamToArray();
        toArrayParallelStream();
    }

    // ---------------------------------------------------------
    // 1. BASIC toArray() (Your original example)
    // ---------------------------------------------------------
    static void basicToArray() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        Object[] array =
                names.stream().toArray();

        System.out.println("1. Basic toArray: " + Arrays.toString(array));
    }

    // ---------------------------------------------------------
    // 2. TYPE-SAFE toArray(IntFunction) (BEST PRACTICE)
    // ---------------------------------------------------------
    static void typedToArray() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Avoids Object[]
        String[] array =
                names.stream()
                        .toArray(String[]::new);

        System.out.println("2. Typed toArray: " + Arrays.toString(array));
    }

    // ---------------------------------------------------------
    // 3. toArray() AFTER filter()
    // ---------------------------------------------------------
    static void toArrayAfterFilter() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        String[] array =
                names.stream()
                        .filter(name -> name.length() > 3)
                        .toArray(String[]::new);

        System.out.println("3. Filter + toArray: " + Arrays.toString(array));
    }

    // ---------------------------------------------------------
    // 4. toArray() AFTER map()
    // ---------------------------------------------------------
    static void toArrayAfterMap() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        String[] array =
                names.stream()
                        .map(String::toUpperCase)
                        .toArray(String[]::new);

        System.out.println("4. Map + toArray: " + Arrays.toString(array));
    }

    // ---------------------------------------------------------
    // 5. toArray() on EMPTY stream
    // ---------------------------------------------------------
    static void emptyStreamToArray() {

        List<String> empty = Arrays.asList();

        String[] array =
                empty.stream().toArray(String[]::new);

        System.out.println("5. Empty stream toArray: " + Arrays.toString(array));
        // Output: []
    }

    // ---------------------------------------------------------
    // 6. toArray() with PARALLEL stream
    // ---------------------------------------------------------
    static void toArrayParallelStream() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Order preserved
        String[] array =
                names.parallelStream()
                        .toArray(String[]::new);

        System.out.println("6. Parallel toArray: " + Arrays.toString(array));
    }
}
