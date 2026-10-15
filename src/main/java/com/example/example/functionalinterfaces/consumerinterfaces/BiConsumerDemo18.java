package level02_intermediate.jdk8.functionalinterfaces.consumerinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * USE CASE:
 * - Grouping results (key + list)
 */
/**
 * Easy: Demonstrates Bi Consumer Demo18 in the Functional Interfaces / Consumer Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BiConsumerDemo18 {
    public static void main(String[] args) {

        Map<Integer, Long> map =
                Stream.of(1, 1, 2, 2, 2)
                        .collect(Collectors.groupingBy(
                                x -> x,
                                Collectors.counting()));

        map.forEach((k, v) -> System.out.println(k + " occurs " + v + " times"));
    }
}
