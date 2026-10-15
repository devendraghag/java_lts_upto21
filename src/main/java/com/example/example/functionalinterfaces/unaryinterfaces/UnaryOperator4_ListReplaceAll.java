package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.UnaryOperator;

/*
 UnaryOperator4: Used with List.replaceAll()
*/
/**
 * Easy: Demonstrates Unary Operator4 List Replace All in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class UnaryOperator4_ListReplaceAll {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3);

        // Replace each element with its square
        numbers.replaceAll(x -> x * x);

        System.out.println(numbers);
    }
}
