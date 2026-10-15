package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Passing behavior as argument
 */
/**
 * Easy: Demonstrates Bi Consumer Demo6 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo6 {

    static void process(int a, int b, BiConsumer<Integer, Integer> bc) {
        bc.accept(a, b);
    }

    public static void main(String[] args) {
        process(10, 3, (x, y) -> System.out.println(x % y));
    }
}
