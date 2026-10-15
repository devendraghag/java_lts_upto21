package com.example.terminaloperations;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Demonstrates why SIDE EFFECTS are dangerous in parallel streams.
 * Shows incorrect and correct approaches.
  * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
  * Tough: Verify that the operation is associative, non-interfering, stateless, and safe under parallel execution.
 */
public class ParallelStreamSideEffectProblemExample {

    public static void main(String[] args) {

        unsafeSideEffect();
        synchronizedFix();
        functionalFix();
    }

    // ---------------------------------------------------------
    // 1. ❌ UNSAFE side effect (Your original example)
    // ---------------------------------------------------------
    static void unsafeSideEffect() {

        List<Integer> list = new ArrayList<>();

        // NOT thread-safe: multiple threads mutate shared state
        IntStream.range(0, 1000)
                .parallel()
                .forEach(list::add);

        System.out.println("1. Unsafe size (may not be 1000): " + list.size());
    }

    // ---------------------------------------------------------
    // 2. ⚠️ Using synchronized collection (Works, but not ideal)
    // ---------------------------------------------------------
    static void synchronizedFix() {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        IntStream.range(0, 1000)
                .parallel()
                .forEach(list::add);

        System.out.println("2. Synchronized size: " + list.size());
    }

    // ---------------------------------------------------------
    // 3. ✅ FUNCTIONAL fix (BEST PRACTICE)
    // ---------------------------------------------------------
    static void functionalFix() {

        List<Integer> list =
                IntStream.range(0, 1000)
                        .parallel()
                        .boxed()
                        .toList(); // Java 16+

        System.out.println("3. Functional size: " + list.size());
    }
}