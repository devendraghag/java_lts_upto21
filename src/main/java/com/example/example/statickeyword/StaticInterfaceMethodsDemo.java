package com.example.statickeyword;

/** Demonstrates public and private static interface methods (Java 8 and 9+). */
public class StaticInterfaceMethodsDemo {
    public static void main(String[] args) {
        System.out.println(TextTools.normalize("  Java   21  "));
        // Static interface methods are called through the interface name.
    }

    private interface TextTools {
        static String normalize(String value) {
            return collapseWhitespace(value.strip());
        }

        private static String collapseWhitespace(String value) {
            return value.replaceAll("\\s+", " ");
        }
    }
}
