package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * Interview level: Beginner.
 * Feature combination/topic: instanceof null behavior.
 *
 * Notes:
 * - Kept in the JDK16 bucket because the demonstrated feature is available in that LTS line.
 * - This program is intentionally small so the interview concept is easy to explain.
 */
/**
 * Easy: Demonstrates Pattern Matching Instanceof03 Null Handling in the Pattern Matching Instanceof topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class PatternMatchingInstanceof03NullHandling {
    public static void main(String[] args) throws Exception {
        Object value = null;
        if (value instanceof String text) {
            System.out.println(text);
        } else {
            System.out.println("no match");
        }
    }
}