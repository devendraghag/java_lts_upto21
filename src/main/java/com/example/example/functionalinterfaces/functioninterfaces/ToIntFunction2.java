package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.ToIntFunction;

/**
 * Easy: Demonstrates To Int Function2 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class ToIntFunction2 {
    public static void main(String[] args) {
        // Parsing String to int
        ToIntFunction<String> parse = Integer::parseInt;
        System.out.println(parse.applyAsInt("100"));
    }
}