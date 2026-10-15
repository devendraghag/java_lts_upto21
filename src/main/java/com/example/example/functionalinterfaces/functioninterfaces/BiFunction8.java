package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function8 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction8 {
    public static void main(String[] args) {

        // Handles null safely
        BiFunction<String, String, String> safeConcat =
                (a, b) -> (a == null ? "" : a) + (b == null ? "" : b);

        System.out.println(safeConcat.apply("Java", null));
    }
}
