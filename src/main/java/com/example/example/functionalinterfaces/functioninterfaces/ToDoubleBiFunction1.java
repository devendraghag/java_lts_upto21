package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToDoubleBiFunction;

/**
 * Easy: Demonstrates To Double Bi Function1 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class ToDoubleBiFunction1 {
    public static void main(String[] args) {
        // Two values -> double
        ToDoubleBiFunction<Integer, Integer> average = (a, b) -> (a + b) / 2.0;
        System.out.println(average.applyAsDouble(10, 20));
    }
}