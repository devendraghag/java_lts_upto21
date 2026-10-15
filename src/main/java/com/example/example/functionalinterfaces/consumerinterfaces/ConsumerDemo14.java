package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Object creation as side-effect
 */
/**
 * Easy: Demonstrates Consumer Demo14 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Box {
    Box(Integer t) {
        System.out.println("Created: " + t);
    }
}

public class ConsumerDemo14 {
    public static void main(String[] args) {

        // accept(t) → new Box(t)
        Consumer<Integer> c = Box::new;

        c.accept(99);
    }
}
