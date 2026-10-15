package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Function;

/**
 * Easy: Demonstrates Function4 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function4 {
    public static void main(String[] args) {

        // Refers to Integer.parseInt(String)
        Function<String, Integer> parseFunction = Integer::parseInt;

        System.out.println(parseFunction.apply("100")); // 100
    }
}
