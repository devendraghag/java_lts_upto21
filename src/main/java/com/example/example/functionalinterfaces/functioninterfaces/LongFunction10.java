package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function10 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction10 {
    public static void main(String[] args) {

        // Transaction classification
        LongFunction<String> transactionType =
                amount -> amount > 100000L ? "HIGH_VALUE" : "NORMAL";

        System.out.println(transactionType.apply(150000L));
    }
}
