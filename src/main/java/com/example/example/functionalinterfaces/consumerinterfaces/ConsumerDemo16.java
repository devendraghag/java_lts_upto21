package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;

/*
 * USE CASE:
 * - Side-effects on collections
 */
/**
 * Easy: Demonstrates Consumer Demo16 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class ConsumerDemo16 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(java.util.Arrays.asList(1, 2, 3));

        // removeIf uses Predicate, forEach uses Consumer
        list.removeIf(x -> x > 1);
        list.forEach(System.out::println);
    }
}
