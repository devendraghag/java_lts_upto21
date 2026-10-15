package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.List;
import java.util.function.BiConsumer;

/**
 * Easy: Demonstrates Bi Consumer Demo14 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo14 {
    public static void main(String[] args) {

        List<String> list = java.util.Arrays.asList("A", "B", "C");

        BiConsumer<Integer, String> consumer =
                (k, v) -> System.out.println(k + ":" + v);

        for (int i = 0; i < list.size(); i++) {
            consumer.accept(i, list.get(i));
        }
    }
}
