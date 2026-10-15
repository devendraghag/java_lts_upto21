package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Optional;

/*
 * USE CASE:
 * - Handle both presence and absence
 */
/**
 * Easy: Demonstrates Consumer Demo13 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo13 {
    public static void main(String[] args) {

        Optional<Integer> op = Optional.empty();

        op.ifPresentOrElse(
            x -> System.out.println(x),       // Consumer
            () -> System.out.println("Empty") // Runnable
        );
    }
}
