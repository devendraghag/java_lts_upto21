package com.example.example.patternmatchingforswitch;

/** Level 11: use yield when a switch-expression case needs multiple statements. */
public class PatternSwitch11YieldInExpression {
    static String summarize(Object value) {
        return switch (value) {
            case String text -> {
                var trimmed = text.trim();
                var length = trimmed.length();
                yield "Text '" + trimmed + "' has " + length + " characters";
            }
            case Integer number -> {
                var doubled = number * 2;
                yield "Doubled number: " + doubled;
            }
            default -> "Other value";
        };
    }

    public static void main(String[] args) {
        System.out.println(summarize("  Java 21  "));
        System.out.println(summarize(21));
        System.out.println(summarize(true));
    }
}
