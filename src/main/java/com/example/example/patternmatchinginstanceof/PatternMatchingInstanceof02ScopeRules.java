package org.example.lts_features.level03_advanced.jdk16.patternmatchinginstanceof;
// JDK history: Pattern matching for instanceof was previewed in JDK 14 and 15, then finalized in JDK 16.


/*
 * JDK 16 introduction-version bucket interview program: pattern variable scope.
 *
 * Interview point:
 * - With &&, the pattern variable is available on the right side.
 * - With ||, it is not safely available because the match may have failed.
 */
/**
 * Easy: Demonstrates Pattern Matching Instanceof02 Scope Rules in the Pattern Matching Instanceof topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Prove exhaustiveness and describe dominance, null handling, guards, and permitted-type restrictions.
 */
public class PatternMatchingInstanceof02ScopeRules {
    public static void main(String[] args) {
        Object value = "scope";

        if (value instanceof String text && text.length() > 3) {
            System.out.println(text.toUpperCase());
        }

        // if (value instanceof String text || text.length() > 3) { } // Invalid.
    }
}

