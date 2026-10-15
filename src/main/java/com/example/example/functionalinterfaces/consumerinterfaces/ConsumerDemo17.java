package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.concurrent.CompletableFuture;

/*
 * USE CASE:
 * - Asynchronous callbacks
 */
/**
 * Easy: Demonstrates Consumer Demo17 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo17 {
    public static void main(String[] args) {

        CompletableFuture
            .completedFuture(5)
            .thenAccept(x -> System.out.println(x * 2));
    }
}
