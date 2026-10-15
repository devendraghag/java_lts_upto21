package level03_advanced.jdk10.localvariabletypeinference.typefixedafterinference;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Type Fixed1 in the Local Variable Type Inference / Type Fixed After Inference topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarTypeFixed1 {
    public static void main(String[] args) {
        var n = 10; // inferred as int
        // n = "Java"; ❌ type cannot be changed
        System.out.println(n);
    }
}