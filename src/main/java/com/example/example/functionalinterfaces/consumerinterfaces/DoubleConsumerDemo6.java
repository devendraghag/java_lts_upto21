package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.stream.DoubleStream;

/**
 * Easy: Demonstrates Double Consumer Demo6 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleConsumerDemo6 {
    public static void main(String[] args) {

        // DoubleStream.forEach expects DoubleConsumer
        DoubleStream.of(1.5, 2.5, 3.5)
                    .forEach(x -> System.out.println("Stream value: " + x));
    }
}
