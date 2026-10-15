package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Grouping behaviors
 */
/**
 * Easy: Demonstrates Bi Consumer Demo13 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo13 {
    public static void main(String[] args) {

        BiConsumer<Integer, Integer>[] ops = new BiConsumer[]{
//            (a, b) -> System.out.println(a + b),
//            (a, b) -> System.out.println(a - b)
        };

        ops[1].accept(10, 4);
    }
}
