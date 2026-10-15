package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Configurable behavior
 */
/**
 * Easy: Demonstrates Bi Consumer Demo11 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo11 {

    static BiConsumer<String, Integer> logger =
            (msg, code) -> System.out.println(msg + " : " + code);

    public static void main(String[] args) {
        logger.accept("SUCCESS", 200);
    }
}
