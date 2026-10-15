package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function9 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction9 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);

        // compute(key, BiFunction)
        map.compute("A", (k, v) -> v + 5);

        System.out.println(map); // {A=15}
    }
}
