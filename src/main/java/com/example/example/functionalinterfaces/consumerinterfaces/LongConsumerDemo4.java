package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongConsumer;

/**
 * Easy: Demonstrates Long Consumer Demo4 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongConsumerDemo4 {
    public static void main(String[] args) {

        // One LongConsumer reused
        LongConsumer logger = x -> System.out.println("Log value: " + x);

        logger.accept(100L);
        logger.accept(200L);
        logger.accept(300L);
    }
}
