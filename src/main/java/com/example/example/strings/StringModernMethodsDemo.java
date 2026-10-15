package com.example.strings;

/** Common String methods added from Java 11 through Java 15. */
public class StringModernMethodsDemo {
    public static void main(String[] args) {
        String spaced = "  Java 21  ";
        System.out.println("strip: [" + spaced.strip() + "]"); // Java 11+, Unicode-aware whitespace.
        System.out.println("trim:  [" + spaced.trim() + "]");
        System.out.println("Blank check: " + " \t\n".isBlank()); // Java 11+
        System.out.println("Repeat: " + "Hi! ".repeat(3)); // Java 11+

        String multiline = "first\nsecond\nthird";
        multiline.lines().forEach(System.out::println); // Java 11+

        String escaped = "first line\\nsecond line\\t(tab)";
        System.out.println(escaped.translateEscapes()); // Java 15+
        System.out.println("  one\n    two\n".indent(2)); // Java 12+
    }
}
