package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function4 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction4 {
    public static void main(String[] args) {

        // Maps long value to category
        LongFunction<String> sizeCategory =
                size -> size > 1_000_000L ? "LARGE" : "SMALL";

        System.out.println(sizeCategory.apply(2_000_000L));
    }
}
