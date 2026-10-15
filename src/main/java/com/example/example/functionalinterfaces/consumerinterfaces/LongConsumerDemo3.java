package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongConsumer;

/**
 * Easy: Demonstrates Long Consumer Demo3 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongConsumerDemo3 {

    // Method that accepts long and behavior
    static void process(long value, LongConsumer consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {

        // Pass lambda as behavior
        process(5L, x -> System.out.println("Square: " + (x * x)));
    }
}
