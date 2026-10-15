package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Saving entity with ID
 */
/**
 * Easy: Demonstrates Bi Consumer Demo19 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo19 {
    public static void main(String[] args) {

        BiConsumer<Integer, String> save =
                (id, name) -> System.out.println("Saved " + id + " : " + name);

        save.accept(101, "UserA");
    }
}
