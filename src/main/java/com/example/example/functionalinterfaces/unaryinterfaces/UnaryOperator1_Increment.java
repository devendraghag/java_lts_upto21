package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.UnaryOperator;

/*
 UnaryOperator1: Increment a number
 Demonstrates basic apply() usage
*/
/**
 * Easy: Demonstrates Unary Operator1 Increment in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class UnaryOperator1_Increment {
    public static void main(String[] args) {
        UnaryOperator<Integer> increment = x -> x + 1;
        System.out.println(increment.apply(10)); // 11
    }
}
