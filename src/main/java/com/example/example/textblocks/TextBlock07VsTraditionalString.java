package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class10: Comparison with traditional string
/**
 * Easy: Demonstrates Text Block07 Vs Traditional String in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock07VsTraditionalString {
    public static void main(String[] args) {

        String oldWay = "Hello\nWorld\nJava";

        String newWay = """
                Hello
                World
                Java
                """;

        System.out.println("Old Way:");
        System.out.println(oldWay);

        System.out.println("New Way:");
        System.out.println(newWay);
    }
}
