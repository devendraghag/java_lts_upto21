package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Bi Function12 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class BiFunction12 {

    static BiFunction<Integer, Integer, Integer> operation(String type) {
        if ("ADD".equals(type))
            return (a, b) -> a + b;
        else
            return (a, b) -> a * b;
    }

    public static void main(String[] args) {
        System.out.println(operation("ADD").apply(3, 4));
    }
}
