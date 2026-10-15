package level03_advanced.jdk10.localvariabletypeinference.nonullinitializer;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Null in the Local Variable Type Inference / No Null Initializer topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarNull {
    public static void main(String[] args) {
        // var x = null; ❌ cannot infer type from null
        String y = null; // valid without var
        System.out.println(y);
    }
}