package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function7 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class IntFunction7 {
    public static void main(String[] args) {

        // Formats number with label
        IntFunction<String> formatter =
                i -> String.format("ID-%04d", i);

        System.out.println(formatter.apply(12));
    }
}
