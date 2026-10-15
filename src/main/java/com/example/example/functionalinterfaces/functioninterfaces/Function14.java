package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;

/**
 * Easy: Demonstrates Function14 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function14 {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);

        // Applies function to each value
        map.replaceAll((k, v) -> v * 2);

        System.out.println(map);
    }
}
