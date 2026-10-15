package com.example.stringmethods;

/** Demonstrates modern String methods added through Java 15. */
public class ModernStringMethodsDemo {
    public static void main(String[] args) {
        String indented = "alpha\nbeta\n".indent(2); // Java 12+.
        System.out.print("indent:\n" + indented);

        String block = """
                red
                  blue
                """;
        System.out.println("stripIndent:\n" + block.stripIndent()); // Java 15+.

        String escaped = "first\\nsecond\\tcolumn".translateEscapes(); // Java 15+.
        System.out.println("translateEscapes:\n" + escaped);
    }
}
