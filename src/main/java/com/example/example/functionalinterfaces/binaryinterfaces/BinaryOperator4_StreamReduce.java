package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.*;
import java.util.function.BinaryOperator;

/*
 BinaryOperator4: Used in Stream reduce()
*/
/**
 * Easy: Demonstrates Binary Operator4 Stream Reduce in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BinaryOperator4_StreamReduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        BinaryOperator<Integer> sum = (a, b) -> a + b;

        int result = list.stream().reduce(0, sum);
        System.out.println(result); // 10
    }
}
