package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Reuse existing static method
 */
/**
 * Easy: Demonstrates Bi Consumer Demo4 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo4 {

    static void printDifference(int a, int b) {
        System.out.println(a - b);
    }

    public static void main(String[] args) {

        // accept(a,b) → printDifference(a,b)
        BiConsumer<Integer, Integer> bc = BiConsumerDemo4::printDifference;
        bc.accept(20, 5);
    }
}
