package level03_advanced.jdk14.switchexpressions;
// JDK history: Switch expressions were previewed in JDK 12 and 13, then finalized in JDK 14.


/*
 * Interview level: Advanced.
 * Feature combination/topic: yield from block.
 *
 * Notes:
 * - Kept in the JDK14 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Switch Expression04 Yield Block in the Switch Expressions topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace the participating threads and compare ordering, visibility, and the final result.
 * Tough: Explain the happens-before relationship and identify any race, deadlock, starvation, or nondeterminism risk.
 */
public class SwitchExpression04YieldBlock {
    public static void main(String[] args) throws Exception {
        int value = 2;
        String result = switch (value) {
            case 1 -> "one";
            default -> { yield "many"; }
        };
        System.out.println(result);
    }
}