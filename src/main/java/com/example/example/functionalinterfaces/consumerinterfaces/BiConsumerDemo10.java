package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.HashMap;
import java.util.Map;

/*
 * USE CASE:
 * - Updating map values
 */
/**
 * Easy: Demonstrates Bi Consumer Demo10 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo10 {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 10);

        // BiConsumer-like logic inside compute
        map.compute(1, (k, v) -> v + 5);

        map.forEach((k, v) -> System.out.println(v));
    }
}
