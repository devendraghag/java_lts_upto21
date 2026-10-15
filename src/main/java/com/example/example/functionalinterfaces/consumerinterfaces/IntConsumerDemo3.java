package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntConsumer;

/**
 * Easy: Demonstrates Int Consumer Demo3 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntConsumerDemo3 {

    // Method accepts int and IntConsumer
    static void process(int value, IntConsumer consumer) {
        consumer.accept(value);
    }

    public static void main(String[] args) {

        // Passing lambda as behavior
        process(4, x -> System.out.println("Cube: " + (x * x * x)));
    }
}
