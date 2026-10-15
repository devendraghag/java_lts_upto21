package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleConsumer;

/**
 * Easy: Demonstrates Double Consumer Demo2 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleConsumerDemo2 {

    // Static method matching accept(double)
    static void printRounded(double value) {
        System.out.println("Rounded value: " + Math.round(value));
    }

    public static void main(String[] args) {

        // accept(value) → printRounded(value)
        DoubleConsumer consumer = DoubleConsumerDemo2::printRounded;

        consumer.accept(12.7);
    }
}
