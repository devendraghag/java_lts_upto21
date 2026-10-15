package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * Interview level: Advanced.
 * Feature combination/topic: negated pattern branch.
 *
 * Notes:
 * - Kept in the JDK16 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Pattern Matching Instanceof04 Negated Pattern in the Pattern Matching Instanceof topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class PatternMatchingInstanceof04NegatedPattern {
    public static void main(String[] args) throws Exception {
        Object value = 10;
        if (!(value instanceof String text)) {
            System.out.println("not string");
            return;
        }
        System.out.println(text);
    }
}