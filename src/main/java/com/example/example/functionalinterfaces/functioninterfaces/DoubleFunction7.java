package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleFunction;

/**
 * Easy: Demonstrates Double Function7 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class DoubleFunction7 {
    public static void main(String[] args) {
        // Business rule mapping
        DoubleFunction<String> taxSlab =
                d -> d > 50000.0 ? "HIGH_TAX" : "LOW_TAX";
        System.out.println(taxSlab.apply(60000.0));
    }
}