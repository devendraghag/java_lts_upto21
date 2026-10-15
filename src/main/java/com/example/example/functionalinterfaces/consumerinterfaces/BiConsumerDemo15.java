package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Logging / auditing
 */
/**
 * Easy: Demonstrates Bi Consumer Demo15 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo15 {
    public static void main(String[] args) {

        BiConsumer<String, Boolean> audit =
                (action, success) ->
                        System.out.println(action + " -> " + success);

        audit.accept("LOGIN", true);
    }
}
