package level02_intermediate.jdk8.functionalinterfaces.unaryinterfaces;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).


import java.util.function.IntUnaryOperator;

/*
 IntUnaryOperator2: Update array values
*/
/**
 * Easy: Demonstrates Int Unary Operator2 Array Update in the Functional Interfaces / Unary Interfaces topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class IntUnaryOperator2_ArrayUpdate {
    public static void main(String[] args) {
        int[] arr = {1,2,3};

        IntUnaryOperator increment = x -> x + 10;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = increment.applyAsInt(arr[i]);
        }

        for (int v : arr) {
            System.out.print(v + " ");
        }
    }
}
