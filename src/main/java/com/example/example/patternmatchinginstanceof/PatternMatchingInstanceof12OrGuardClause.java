package com.example.example.patternmatchinginstanceof;

/** Level 12: use a negated pattern with || in a guard clause. */
public class PatternMatchingInstanceof12OrGuardClause {
    static void printUppercaseIfUseful(Object value) {
        // On the right side of ||, text is available because reaching it means
        // the left side was false, so value matched String.
        if (!(value instanceof String text) || text.isBlank()) {
            System.out.println("No non-blank text");
            return;
        }

        // If the if-condition was false, value matched and text was not blank.
        System.out.println(text.toUpperCase());
    }

    public static void main(String[] args) {
        printUppercaseIfUseful("Java");
        printUppercaseIfUseful("   ");
        printUppercaseIfUseful(21);
    }
}
