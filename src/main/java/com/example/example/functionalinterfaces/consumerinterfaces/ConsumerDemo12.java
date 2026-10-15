package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Optional;

/*
 * USE CASE:
 * - Execute logic only if value exists
 */
/**
 * Easy: Demonstrates Consumer Demo12 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo12 {
    public static void main(String[] args) {

        Optional.of(10)
                .ifPresent(x -> System.out.println(x));
    }
}
