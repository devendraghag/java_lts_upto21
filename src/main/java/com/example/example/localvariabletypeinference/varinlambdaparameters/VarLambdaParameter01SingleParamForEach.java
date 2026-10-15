package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.util.List;

/**
 * Easy: Demonstrates Var Lambda Parameter01 Single Param For Each in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
public class VarLambdaParameter01SingleParamForEach {

    public static void main(String[] args) {

        // Create an immutable list of strings
        List<String> names = List.of("java", "jdk", "lambda");

        // Lambda expression using 'var' for parameter
        // 'var' lets the compiler infer the type (String here)
        // Parentheses are mandatory when using 'var'
        names.forEach((var name) -> {
            // Convert each name to uppercase
            System.out.println(name.toUpperCase());
        });
    }
}