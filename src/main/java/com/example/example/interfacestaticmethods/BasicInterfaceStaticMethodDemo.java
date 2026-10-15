package com.example.interfacestaticmethods;

/** Demonstrates that an interface static method is called through its interface. */
public class BasicInterfaceStaticMethodDemo {
    private interface TextTools {
        static String surround(String text) {
            return "[" + text + "]";
        }
    }

    private static final class TextToolsImplementation implements TextTools {
        // Static interface methods are not inherited by implementing classes.
        private static String surround(String text) {
            return "{" + text + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println(TextTools.surround("interface method"));
        System.out.println(TextToolsImplementation.surround("class method"));
    }
}
