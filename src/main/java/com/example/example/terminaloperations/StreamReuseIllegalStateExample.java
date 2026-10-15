package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.List;
import java.util.stream.Stream;

/**
 * Demonstrates that a Stream CANNOT be reused after a terminal operation.
 *
 * Once a terminal operation is executed, the stream is CLOSED.
 * Any further operation causes IllegalStateException.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class StreamReuseIllegalStateExample {

    public static void main(String[] args) {

        illegalReuse();
        safeReuseUsingNewStream();
        safeReuseUsingSupplier();
        explanation();
    }

    // ---------------------------------------------------------
    // 1. ❌ ILLEGAL stream reuse (Your original example)
    // ---------------------------------------------------------
    static void illegalReuse() {

        Stream<Integer> stream = Stream.of(1, 2, 3);

        // Terminal operation #1
        stream.forEach(System.out::println);

        // Terminal operation #2 → IllegalStateException
        try {
            stream.count(); // ❌ stream already closed
        } catch (IllegalStateException e) {
            System.out.println("1. Illegal reuse caught: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // 2. ✅ SAFE reuse by creating a NEW stream
    // ---------------------------------------------------------
    static void safeReuseUsingNewStream() {

        List<Integer> numbers = java.util.Arrays.asList(1, 2, 3);

        // Each stream() call creates a NEW stream
        numbers.stream().forEach(System.out::println);
        long count = numbers.stream().count();

        System.out.println("2. Safe reuse (new stream): " + count);
    }

    // ---------------------------------------------------------
    // 3. ✅ SAFE reuse using Supplier<Stream<T>>
    // ---------------------------------------------------------
    static void safeReuseUsingSupplier() {

        // Supplier provides a FRESH stream each time
        java.util.function.Supplier<Stream<Integer>> supplier =
                () -> Stream.of(1, 2, 3);

        supplier.get().forEach(System.out::println);
        long count = supplier.get().count();

        System.out.println("3. Safe reuse (supplier): " + count);
    }

    // ---------------------------------------------------------
    // 4. Key explanation (Interview-ready)
    // ---------------------------------------------------------
    static void explanation() {

        System.out.println("""
                Explanation:
                - Streams are single-use
                - Terminal operation closes the stream
                - Reusing a stream throws IllegalStateException
                - Always create a new stream when needed
                """);
    }
}
