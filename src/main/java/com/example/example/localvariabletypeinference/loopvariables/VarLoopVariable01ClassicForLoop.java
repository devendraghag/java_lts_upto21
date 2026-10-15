package level03_advanced.jdk10.localvariabletypeinference.loopvariables;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

/**
 * Easy: Demonstrates Var Loop Variable01 Classic For Loop in the Local Variable Type Inference / Loop Variables topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarLoopVariable01ClassicForLoop {
    public static void main(String[] args) {
        for (var i = 0; i < 3; i++) {
            System.out.println(i);
        }
    }
}