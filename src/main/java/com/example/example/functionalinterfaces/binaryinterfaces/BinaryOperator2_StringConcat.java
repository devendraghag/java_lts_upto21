package level02_intermediate.jdk8.functionalinterfaces.binaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.BinaryOperator;

/*
 BinaryOperator2: Concatenate two strings
*/
/**
 * Easy: Demonstrates Binary Operator2 String Concat in the Functional Interfaces / Binary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class BinaryOperator2_StringConcat {
    public static void main(String[] args) {
        BinaryOperator<String> concat = (a, b) -> a + b;
        System.out.println(concat.apply("Hello ", "World"));
    }
}
