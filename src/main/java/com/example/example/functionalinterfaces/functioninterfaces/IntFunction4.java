package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function4 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class IntFunction4 {
    public static void main(String[] args) {

        // Maps int to grade
        IntFunction<String> grade =
                marks -> marks >= 60 ? "PASS" : "FAIL";

        System.out.println(grade.apply(55));
    }
}
