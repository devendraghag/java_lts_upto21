package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.LongConsumer;

/**
 * Easy: Demonstrates Long Consumer Demo7 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class LongConsumerDemo7 {
    public static void main(String[] args) {

        // Simulating timestamp processing
        LongConsumer timestampPrinter =
                ts -> System.out.println("Timestamp(ms): " + ts);

        timestampPrinter.accept(System.currentTimeMillis());
    }
}
