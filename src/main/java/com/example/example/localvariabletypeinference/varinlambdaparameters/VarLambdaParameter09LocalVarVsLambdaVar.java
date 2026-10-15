package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.util.List;

/**
 * Easy: Demonstrates Var Lambda Parameter09 Local Var Vs Lambda Var in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter09LocalVarVsLambdaVar {

    public static void main(String[] args) {

        // Local variable 'var' (introduced in Java 10)
        // Cannot use annotations here
        var numbers = List.of(1, 2, 3);

        // Lambda parameter 'var' (introduced in Java 11)
        // Annotations ARE allowed here
        numbers.forEach((var n) -> {

            // n is inferred as Integer
            System.out.println(n * 2);
        });
    }
}
