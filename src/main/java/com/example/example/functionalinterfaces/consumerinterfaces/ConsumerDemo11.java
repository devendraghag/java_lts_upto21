package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.Stream;

/*
 * USE CASE:
 * - Debugging stream pipelines
 */
/**
 * Easy: Demonstrates Consumer Demo11 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo11 {
    public static void main(String[] args) {

        Stream.of(1, 2, 3)
              .peek(x -> System.out.println("Peek: " + x))
              .map(x -> x * 2)
              .toList();
    }
}
