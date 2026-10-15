package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToDoubleFunction;

/**
 * Easy: Demonstrates To Double Function1 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class ToDoubleFunction1 {
    public static void main(String[] args) {
        // Object -> double mapping
        ToDoubleFunction<Integer> sqrt =
                n -> Math.sqrt(n);
        System.out.println(sqrt.applyAsDouble(16));
    }
}