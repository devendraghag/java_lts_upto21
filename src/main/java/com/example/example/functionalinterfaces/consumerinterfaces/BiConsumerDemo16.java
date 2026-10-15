package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Validating two values together
 */
/**
 * Easy: Demonstrates Bi Consumer Demo16 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo16 {
    public static void main(String[] args) {

        BiConsumer<Integer, Integer> validator =
                (min, value) -> {
                    if (value < min)
                        System.out.println("Invalid");
                    else
                        System.out.println("Valid");
                };

        validator.accept(10, 12);
    }
}
