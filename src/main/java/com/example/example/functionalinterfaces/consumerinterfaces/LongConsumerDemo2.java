package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongConsumer;

/**
 * Easy: Demonstrates Long Consumer Demo2 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongConsumerDemo2 {

    // Static method matching accept(long)
    static void printInKB(long bytes) {
        System.out.println("Size in KB: " + (bytes / 1024));
    }

    public static void main(String[] args) {

        // accept(value) → printInKB(value)
        LongConsumer consumer = LongConsumerDemo2::printInKB;

        consumer.accept(10_240L);
    }
}
