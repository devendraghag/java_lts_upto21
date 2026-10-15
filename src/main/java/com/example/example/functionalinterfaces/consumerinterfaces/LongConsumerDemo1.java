package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongConsumer;

/**
 * Easy: Demonstrates Long Consumer Demo1 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongConsumerDemo1 {
    public static void main(String[] args) {

        // Lambda-based LongConsumer
        LongConsumer consumer = value ->
                System.out.println("Double value: " + (value * 2));

        consumer.accept(1_000_000_000L);
    }
}
