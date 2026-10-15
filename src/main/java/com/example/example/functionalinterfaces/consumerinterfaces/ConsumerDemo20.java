package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.Consumer;

/*
 * USE CASE:
 * - Multiple behaviors grouped together
 */
/**
 * Easy: Demonstrates Consumer Demo20 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo20 {
    public static void main(String[] args) {

        Consumer<Integer>[] actions = new Consumer[]{
            x -> System.out.println(x),
//            x -> System.out.println(x * x)
                x -> System.out.println(x)
        };

        actions[1].accept(6);
    }
}
