package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.Function;

/**
 * Easy: Demonstrates Function15 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function15 {
    public static void main(String[] args) {

        Map<Integer, Integer> cache = new HashMap<>();

        // Stores computed result for reuse
        Function<Integer, Integer> square =
                n -> cache.computeIfAbsent(n, k -> k * k);

        System.out.println(square.apply(5));
        System.out.println(square.apply(5)); // cached
    }
}
