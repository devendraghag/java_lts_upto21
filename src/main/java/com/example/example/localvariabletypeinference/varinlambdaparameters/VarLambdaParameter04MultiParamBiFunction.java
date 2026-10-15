package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.util.function.BiFunction;

/**
 * Easy: Demonstrates Var Lambda Parameter04 Multi Param Bi Function in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter04MultiParamBiFunction {

    public static void main(String[] args) {

        // BiFunction takes two inputs and produces one output
        // Using 'var' for BOTH parameters is mandatory
        BiFunction<Integer, Integer, Integer> sum =
                (var a, var b) -> {
                    // a and b are inferred as Integer
                    return a + b;
                };

        // Invoke the lambda
        System.out.println(sum.apply(10, 20));
    }
}
