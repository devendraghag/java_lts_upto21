package com.example.interfaces;

/** Demonstrates static methods and private helper methods in interfaces (Java 9+). */
public class StaticAndPrivateInterfaceMethodsDemo {
    private interface TextRules {
        static boolean isBlank(String text) {
            return text == null || normalize(text).isEmpty();
        }

        default String normalized(String text) {
            return normalize(text);
        }

        private static String normalize(String text) {
            return text == null ? "" : text.trim();
        }
    }

    private static final class TextValue implements TextRules {
    }

    public static void main(String[] args) {
        TextRules rules = new TextValue();
        System.out.println("Normalized: '" + rules.normalized("  Java  ") + "'");
        System.out.println("Blank: " + TextRules.isBlank("   "));
    }
}
