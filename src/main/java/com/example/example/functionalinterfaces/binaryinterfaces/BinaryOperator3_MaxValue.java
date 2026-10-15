package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BinaryOperator;

/*
 BinaryOperator3: Find max of two values
*/
/**
 * Easy: Demonstrates Binary Operator3 Max Value in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BinaryOperator3_MaxValue {
    public static void main(String[] args) {
        BinaryOperator<Integer> max = Integer::max;
        System.out.println(max.apply(50, 30));
    }
}
