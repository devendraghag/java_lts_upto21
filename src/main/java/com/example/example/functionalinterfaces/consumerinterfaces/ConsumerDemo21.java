package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Immutable functional configuration
 */
/**
 * Easy: Demonstrates Consumer Demo21 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Action {
    private final Consumer<Integer> consumer;

    Action(Consumer<Integer> consumer) {
        this.consumer = consumer;
    }

    Consumer<Integer> consumer() {
        return consumer;
    }
}

public class ConsumerDemo21 {
    public static void main(String[] args) {

        Action a = new Action(x -> System.out.println(x - 2));

        a.consumer().accept(10);
    }
}
