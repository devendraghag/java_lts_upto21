package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.LongStream;

/**
 * Easy: Demonstrates Long Consumer Demo6 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongConsumerDemo6 {
    public static void main(String[] args) {

        // LongStream.forEach expects LongConsumer
        LongStream.of(10L, 20L, 30L)
                  .forEach(x -> System.out.println("Stream value: " + x));
    }
}
