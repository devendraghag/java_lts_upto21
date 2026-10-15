package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Factory pattern
 */
/**
 * Easy: Demonstrates Consumer Demo19 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo19 {

    static Consumer<Integer> getConsumer() {
        return x -> System.out.println(x * 3);
    }

    public static void main(String[] args) {
        getConsumer().accept(4);
    }
}
