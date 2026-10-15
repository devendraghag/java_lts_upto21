package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleConsumer;

/**
 * Easy: Demonstrates Double Consumer Demo4 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleConsumerDemo4 {
    public static void main(String[] args) {

        // Reusable DoubleConsumer
        DoubleConsumer printer =
                x -> System.out.println("Value: " + x);

        printer.accept(1.1);
        printer.accept(2.2);
        printer.accept(3.3);
    }
}
