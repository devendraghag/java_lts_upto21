package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function1 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction1 {
    public static void main(String[] args) {

        // Takes two integers and returns their sum
        BiFunction<Integer, Integer, Integer> add =
                (a, b) -> a + b;

        System.out.println(add.apply(10, 20)); // 30
    }
}
