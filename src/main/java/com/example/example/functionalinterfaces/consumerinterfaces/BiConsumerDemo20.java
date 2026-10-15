package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.HashMap;
import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Updating configuration
 */
/**
 * Easy: Demonstrates Bi Consumer Demo20 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo20 {
    public static void main(String[] args) {

        HashMap<String, String> config = new HashMap<>();

        BiConsumer<String, String> updater = config::put;

        updater.accept("url", "localhost");
        updater.accept("port", "8080");

        config.forEach((k, v) -> System.out.println(k + "=" + v));
    }
}
