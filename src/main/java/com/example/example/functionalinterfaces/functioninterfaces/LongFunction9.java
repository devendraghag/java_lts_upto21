package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function9 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction9 {
    public static void main(String[] args) {

        // Protects against runtime errors
        LongFunction<String> safeMapper =
                l -> {
                    try {
                        return "Processed: " + l;
                    } catch (Exception e) {
                        return "Error";
                    }
                };

        System.out.println(safeMapper.apply(5L));
    }
}
