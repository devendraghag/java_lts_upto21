package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function13 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction13 {
    public static void main(String[] args) {

        // Safe division
        BiFunction<Integer, Integer, Integer> safeDivide =
                (a, b) -> {
                    try {
                        return a / b;
                    } catch (Exception e) {
                        return 0;
                    }
                };

        System.out.println(safeDivide.apply(10, 0));
    }
}
