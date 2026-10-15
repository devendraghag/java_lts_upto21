package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Function;

/**
 * Easy: Demonstrates Function5 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function5 {
    public static void main(String[] args) {

        // First function: get length
        Function<String, Integer> length = String::length;

        // Second function: convert number to message
        Function<Integer, String> message = i -> "Length is " + i;

        // length → message
        System.out.println(length.andThen(message).apply("Java"));
    }
}
