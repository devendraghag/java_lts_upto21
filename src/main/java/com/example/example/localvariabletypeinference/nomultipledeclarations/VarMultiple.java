package level03_advanced.jdk10.localvariabletypeinference.nomultipledeclarations;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Multiple in the Local Variable Type Inference / No Multiple Declarations topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarMultiple {
    public static void main(String[] args) {
        var a = 10;
        // var b = 10, c = 20; ❌ multiple declaration not allowed
        System.out.println(a);
    }
}