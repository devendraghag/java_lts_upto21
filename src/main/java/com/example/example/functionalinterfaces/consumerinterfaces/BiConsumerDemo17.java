package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.concurrent.CompletableFuture;

/*
 * USE CASE:
 * - Async combination of two results
 */
/**
 * Easy: Demonstrates Bi Consumer Demo17 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo17 {
    public static void main(String[] args) {

        CompletableFuture<Integer> f1 = CompletableFuture.completedFuture(5);
        CompletableFuture<Integer> f2 = CompletableFuture.completedFuture(6);

        f1.thenAcceptBoth(f2, (a, b) -> System.out.println(a + b));
    }
}
