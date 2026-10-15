package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BiConsumer;

/*
 * USE CASE:
 * - Immutable functional configuration
 */
/**
 * Easy: Demonstrates Bi Consumer Demo21 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Actiona {
    private final BiConsumer<Integer, Integer> biConsumer;

    Actiona(BiConsumer<Integer, Integer> biConsumer) {
        this.biConsumer = biConsumer;
    }

    BiConsumer<Integer, Integer> biConsumer() {
        return biConsumer;
    }
}

public class BiConsumerDemo21 {
    public static void main(String[] args) {

        Actiona action =
                new Actiona((a, b) -> System.out.println((a + b) * 2));

        action.biConsumer().accept(3, 4);
    }
}
