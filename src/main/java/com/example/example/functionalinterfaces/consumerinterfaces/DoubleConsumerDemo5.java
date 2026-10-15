package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleConsumer;

/**
 * Easy: Demonstrates Double Consumer Demo5 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleConsumerDemo5 {
    public static void main(String[] args) {

        DoubleConsumer c1 =
                x -> System.out.println("Original: " + x);

        DoubleConsumer c2 =
                x -> System.out.println("Ceil: " + Math.ceil(x));

        // Execute c1 then c2
        c1.andThen(c2).accept(5.4);
    }
}
