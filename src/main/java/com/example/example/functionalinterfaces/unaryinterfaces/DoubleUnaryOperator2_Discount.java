package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.DoubleUnaryOperator;

/*
 DoubleUnaryOperator2: Apply discount calculation
*/
/**
 * Easy: Demonstrates Double Unary Operator2 Discount in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class DoubleUnaryOperator2_Discount {
    public static void main(String[] args) {
        DoubleUnaryOperator discount = price -> price * 0.9;
        System.out.println(discount.applyAsDouble(1000));
    }
}
