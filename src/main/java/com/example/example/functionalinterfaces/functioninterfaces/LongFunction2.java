package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongFunction;

/**
 * Easy: Demonstrates Long Function2 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class LongFunction2 {
    public static void main(String[] args) {

        // Boxes primitive long into Long object
        LongFunction<Long> boxLong = Long::valueOf;

        System.out.println(boxLong.apply(500L));
    }
}
