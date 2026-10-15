package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Multiple actions on same two inputs
 */
/**
 * Easy: Demonstrates Bi Consumer Demo8 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo8 {
    public static void main(String[] args) {

        BiConsumer<Integer, Integer> bc1 =
                (a, b) -> System.out.println("A = " + a);

        BiConsumer<Integer, Integer> bc2 =
                (a, b) -> System.out.println("B = " + b);

        // bc1 executes first, then bc2
        bc1.andThen(bc2).accept(7, 9);
    }
}
