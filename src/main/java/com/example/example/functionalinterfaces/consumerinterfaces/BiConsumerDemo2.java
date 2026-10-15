package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - One-time usage
 * - Pre-Java-8 style
 */
/**
 * Easy: Demonstrates Bi Consumer Demo2 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo2 {
    public static void main(String[] args) {

        BiConsumer<String, String> bc = new BiConsumer<String, String>() {
            @Override
            public void accept(String a, String b) {
                System.out.println(a.concat(b));
            }
        };

        bc.accept("Java", "8");
    }
}
