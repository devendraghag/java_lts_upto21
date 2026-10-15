package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Modern Java
 * - Most common style
 */
/**
 * Easy: Demonstrates Bi Consumer Demo3 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo3 {
    public static void main(String[] args) {

        // Lambda = implementation of accept(a, b)
        BiConsumer<Integer, Integer> bc = (a, b) -> System.out.println(a * b);

        bc.accept(5, 4);
    }
}
