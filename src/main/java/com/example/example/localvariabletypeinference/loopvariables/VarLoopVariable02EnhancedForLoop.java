package level03_advanced.jdk10.localvariabletypeinference.loopvariables;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

import java.util.List;
/**
 * Easy: Demonstrates Var Loop Variable02 Enhanced For Loop in the Local Variable Type Inference / Loop Variables topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarLoopVariable02EnhancedForLoop {
    public static void main(String[] args) {
        var list = List.of("A", "B", "C");
        for (var s : list) {
            System.out.println(s);
        }
    }
}