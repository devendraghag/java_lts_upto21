package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Configurable behavior
 */
/**
 * Easy: Demonstrates Consumer Demo18 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo18 {

    // Consumer stored as field
    static Consumer<Integer> c = x -> System.out.println(x + 1);

    public static void main(String[] args) {
        c.accept(7);
    }
}
