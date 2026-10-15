package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function8 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction8 {
    public static void main(String[] args) {

        String[] levels = {"LOW", "MEDIUM", "HIGH"};

        // Maps index (long) to value
        LongFunction<String> lookup =
                i -> levels[(int) i];

        System.out.println(lookup.apply(2L));
    }
}
