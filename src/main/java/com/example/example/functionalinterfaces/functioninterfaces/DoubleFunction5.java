package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleFunction;

/**
 * Easy: Demonstrates Double Function5 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class DoubleFunction5 {
    public static void main(String[] args) {
        // Formatting logic
        DoubleFunction<String> currency =
                d -> String.format("$%.2f", d);
        System.out.println(currency.apply(45.678));
    }
}