package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntConsumer;

/**
 * Easy: Demonstrates Int Consumer Demo2 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntConsumerDemo2 {

    // Static method matching accept(int)
    static void printSquare(int value) {
        System.out.println("Square: " + (value * value));
    }

    public static void main(String[] args) {

        // Method reference maps accept(value) → printSquare(value)
        IntConsumer consumer = IntConsumerDemo2::printSquare;

        consumer.accept(5);
    }
}
