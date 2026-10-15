package level03_advanced.jdk10.localvariabletypeinference.trywithresources;
// JDK history: Introduction baseline: JDK 10 (the release bucket for this topic).

import java.io.*;
/**
 * Easy: Demonstrates Var Try in the Local Variable Type Inference / Try With Resources topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
public class VarTry {
    public static void main(String[] args) throws Exception {
        // var allowed in try-with-resources (JDK 11+)
        try (var br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        }
    }
}