package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.DoubleFunction;

/**
 * Easy: Demonstrates Double Function8 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class DoubleFunction8 {
    public static void main(String[] args) {
        // Caching / memoization
        Map<Double, String> cache = new HashMap<>();
        DoubleFunction<String> cached =
                d -> cache.computeIfAbsent(d, k -> "Computed-" + k);
        System.out.println(cached.apply(5.5));
        System.out.println(cached.apply(5.5));
    }
}