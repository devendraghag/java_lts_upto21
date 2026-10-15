package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Factory pattern
 */
/**
 * Easy: Demonstrates Bi Consumer Demo12 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo12 {

    static BiConsumer<Integer, Integer> getBiConsumer() {
        return (a, b) -> System.out.println(a * a + b * b);
    }

    public static void main(String[] args) {
        getBiConsumer().accept(3, 4);
    }
}
