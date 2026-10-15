package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntBinaryOperator;

/*
 IntBinaryOperator1: Add two ints
*/
/**
 * Easy: Demonstrates Int Binary Operator1 Add in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntBinaryOperator1_Add {
    public static void main(String[] args) {
        IntBinaryOperator add = (a, b) -> a + b;
        System.out.println(add.applyAsInt(5, 7));
    }
}
