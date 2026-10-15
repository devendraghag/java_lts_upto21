package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToIntBiFunction;

/**
 * Easy: Demonstrates To Int Bi Function2 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class ToIntBiFunction2 {
    public static void main(String[] args) {
        // Arithmetic calculation
        ToIntBiFunction<Integer, Integer> add =
                (a, b) -> a + b;
        System.out.println(add.applyAsInt(10, 20));
    }
}