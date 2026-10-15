package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleConsumer;

/**
 * Easy: Demonstrates Double Consumer Demo7 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleConsumerDemo7 {
    public static void main(String[] args) {

        // Processing a metric value
        DoubleConsumer metricProcessor =
                score -> {
                    if (score >= 90)
                        System.out.println("Grade: A");
                    else
                        System.out.println("Grade: B");
                };

        metricProcessor.accept(92.5);
    }
}
