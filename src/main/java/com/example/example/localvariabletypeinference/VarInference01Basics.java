package level03_advanced.jdk10.localvariabletypeinference;


import java.util.ArrayList;
import java.util.List;

/*
 * JDK 10 introduction-version bucket: local variable type inference with var.
 *
 * Interview point:
 * - var is not dynamic typing.
 * - The compiler fixes the type from the initializer.
 * - var cannot be used for fields or method parameters in normal methods.
 */
/**
 * Easy: Demonstrates Var Inference01 Basics in the Local Variable Type Inference topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: State the inferred static type and identify every context where var remains illegal or misleading.
 */
public class VarInference01Basics {
    public static void main(String[] args) {
        var names = new ArrayList<String>();
        names.add("Amit");
        names.add("Riya");

        List<String> sameType = names;
        System.out.println(sameType);
    }
}

