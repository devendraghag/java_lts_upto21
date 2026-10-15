package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function14 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction14 {
    public static void main(String[] args) {

        // Logs and then returns result
        LongFunction<String> logger =
                l -> {
                    System.out.println("Processing long: " + l);
                    return "Done";
                };

        System.out.println(logger.apply(3L));
    }
}
