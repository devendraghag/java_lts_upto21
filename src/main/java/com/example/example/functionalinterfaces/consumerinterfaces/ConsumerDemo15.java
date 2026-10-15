package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Map;
import java.util.HashMap;

/*
 * USE CASE:
 * - Processing map entries
 */
/**
 * Easy: Demonstrates Consumer Demo15 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo15 {
    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "A");

        map.forEach((k, v) -> System.out.println(k + v));
    }
}
