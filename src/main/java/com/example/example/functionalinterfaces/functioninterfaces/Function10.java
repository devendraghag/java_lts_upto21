package level02_intermediate.jdk8.functionalinterfaces.functioninterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.Function;

/**
 * Easy: Demonstrates Function10 in the Functional Interfaces / Function Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
class Function10 {
    public static void main(String[] args) {

        List<String> list = java.util.Arrays.asList("a", "bb", "ccc");

        // map() internally uses Function
        list.stream()
            .map(String::length)
            .forEach(System.out::println);
    }
}
