package level03_advanced.jdk09.trywithresourcesenhancement;
// JDK history: Introduction baseline: JDK 9 (the release bucket for this topic).


import java.io.*;
/**
 * Easy: Demonstrates Try With Resources Enh01 Basic Valid Usage in the Try With Resources Enhancement topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
public class TryWithResourcesEnh01BasicValidUsage {
    public static void main(String[] args) throws Exception {
        // Java 9 enhancement: resource declared outside
        BufferedReader br =
            new BufferedReader(new FileReader("test.txt"));
        try (br) {
            System.out.println(br.readLine());
        }
    }
}