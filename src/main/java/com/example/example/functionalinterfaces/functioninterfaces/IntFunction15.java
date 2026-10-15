package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntFunction;

/**
 * Easy: Demonstrates Int Function15 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
enum Status { LOW, MEDIUM, HIGH }

public class IntFunction15 {
    public static void main(String[] args) {

        // Maps score to enum
        IntFunction<Status> statusMapper =
                score -> score > 80 ? Status.HIGH : Status.LOW;

        System.out.println(statusMapper.apply(90));
    }
}
