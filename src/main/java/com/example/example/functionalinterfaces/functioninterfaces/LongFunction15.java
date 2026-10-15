package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function15 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
enum Priority { LOW, MEDIUM, HIGH }

public class LongFunction15 {
    public static void main(String[] args) {

        // Maps value to enum
        LongFunction<Priority> priorityMapper =
                v -> v > 1000L ? Priority.HIGH : Priority.LOW;

        System.out.println(priorityMapper.apply(5000L));
    }
}
