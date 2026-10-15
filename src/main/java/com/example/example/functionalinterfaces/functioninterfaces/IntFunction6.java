package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function6 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class IntFunction6 {
    public static void main(String[] args) {

        List<String> list = java.util.Arrays.asList("A", "B", "C");

        // IntFunction is used by toArray()
        String[] arr = list.stream()
                           .toArray(String[]::new);

        System.out.println(Arrays.toString(arr));
    }
}
