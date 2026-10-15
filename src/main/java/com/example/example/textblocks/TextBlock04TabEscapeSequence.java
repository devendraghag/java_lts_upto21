package level03_advanced.jdk15.textblocks;
// JDK history: Introduction baseline: JDK 15 (the release bucket for this topic).


// Class5: Using escape sequences inside Text Blocks
/**
 * Easy: Demonstrates Text Block04 Tab Escape Sequence in the Text Blocks topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class TextBlock04TabEscapeSequence {
    public static void main(String[] args) {

        String data = """
                Name\tAge\tCity
                Dev\t25\tPune
                Raj\t30Mumbai
                """;

        // \t still works for tabs
        System.out.println(data);
    }
}
