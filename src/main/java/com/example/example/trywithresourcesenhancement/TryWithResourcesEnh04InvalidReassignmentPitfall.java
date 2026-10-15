package level03_advanced.jdk09.trywithresourcesenhancement;
// JDK history: Introduction baseline: JDK 9 (the release bucket for this topic).


import java.io.*;
/**
 * Easy: Demonstrates Try With Resources Enh04 Invalid Reassignment Pitfall in the Try With Resources Enhancement topic.
 * Inspect the commented example to see which usage the compiler rejects.
 * Medium: Identify the exact compiler rule before checking the commented invalid statement.
 * Tough: Explain the compile-time failure precisely, then state the smallest valid correction.
 */
public class TryWithResourcesEnh04InvalidReassignmentPitfall {
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new FileReader("a.txt"));
        br = new BufferedReader(new FileReader("b.txt"));
        // try (br) {} // Compilation error: not effectively final
    }
}