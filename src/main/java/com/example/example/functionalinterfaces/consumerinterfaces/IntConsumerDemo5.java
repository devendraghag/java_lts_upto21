package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntConsumer;

/**
 * Easy: Demonstrates Int Consumer Demo5 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntConsumerDemo5 {
    public static void main(String[] args) {

        IntConsumer c1 = x -> System.out.println("Original: " + x);
        IntConsumer c2 = x -> System.out.println("Triple: " + (x * 3));

        // First c1 runs, then c2
        c1.andThen(c2).accept(7);
    }
}
