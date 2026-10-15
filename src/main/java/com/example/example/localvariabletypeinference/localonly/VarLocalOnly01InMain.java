package level03_advanced.jdk10.localvariabletypeinference.localonly;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Local Only01 In Main in the Local Variable Type Inference / Local Only topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarLocalOnly01InMain {
    public static void main(String[] args) {
        // var is allowed ONLY for local variables (JDK 10)
        var x = 10; // compiler infers int
        System.out.println(x);
    }
}