package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function1 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class IntFunction1 {
    public static void main(String[] args) {

        // Takes int and returns String representation
        IntFunction<String> intToString = i -> "Value: " + i;

        System.out.println(intToString.apply(10));
    }
}
