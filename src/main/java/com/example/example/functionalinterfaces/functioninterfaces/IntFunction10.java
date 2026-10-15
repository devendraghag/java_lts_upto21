package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function10 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class IntFunction10 {
    public static void main(String[] args) {

        // Salary band calculation
        IntFunction<String> salaryBand =
                salary -> salary > 50000 ? "HIGH" : "NORMAL";

        System.out.println(salaryBand.apply(60000));
    }
}
