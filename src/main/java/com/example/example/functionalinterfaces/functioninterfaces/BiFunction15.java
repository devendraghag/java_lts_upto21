package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function15 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction15 {
    public static void main(String[] args) {

        Map<String, Integer> cache = new HashMap<>();

        BiFunction<String, Integer, Integer> computeLength =
                (s, x) -> cache.computeIfAbsent(s + x, k -> s.length() + x);

        System.out.println(computeLength.apply("Java", 5));
        System.out.println(computeLength.apply("Java", 5)); // cached
    }
}
