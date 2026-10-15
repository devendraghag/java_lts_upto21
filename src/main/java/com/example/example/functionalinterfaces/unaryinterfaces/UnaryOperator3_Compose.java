package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.UnaryOperator;

/*
 UnaryOperator3: Function composition using andThen()
*/
/**
 * Easy: Demonstrates Unary Operator3 Compose in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class UnaryOperator3_Compose {
    public static void main(String[] args) {
        UnaryOperator<Integer> doubleValue = x -> x * 2;
        UnaryOperator<Integer> square = x -> x * x;

        // First double, then square
        System.out.println(doubleValue.andThen(square).apply(3)); // 36
    }
}
