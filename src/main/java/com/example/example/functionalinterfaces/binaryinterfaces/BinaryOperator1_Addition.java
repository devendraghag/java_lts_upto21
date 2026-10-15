package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BinaryOperator;

/*
 BinaryOperator1: Add two integers
 Demonstrates basic apply() usage
*/
/**
 * Easy: Demonstrates Binary Operator1 Addition in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BinaryOperator1_Addition {
    public static void main(String[] args) {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20)); // 30
    }
}
///BinaryOperator<T> takes two inputs of the same type and returns the same type.