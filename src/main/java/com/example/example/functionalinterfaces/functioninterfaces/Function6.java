package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Function;

/**
 * Easy: Demonstrates Function6 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function6 {
    public static void main(String[] args) {

        // Removes spaces before processing
        Function<String, String> trim = String::trim;

        // Calculates string length
        Function<String, Integer> length = String::length;

        // trim runs first, then length
        System.out.println(length.compose(trim).apply("  Java  "));
    }
}
