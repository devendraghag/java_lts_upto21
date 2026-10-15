package com.example.interfacestaticmethods;

/** Demonstrates a private static interface helper (Java 9+) and overloaded public methods. */
public class PrivateStaticInterfaceHelperDemo {
    private interface MessageTools {
        static String format(String message) {
            return decorate(normalize(message));
        }

        static String format(String message, String tag) {
            return decorate("[" + normalize(tag) + "] " + normalize(message));
        }

        private static String normalize(String value) {
            return value == null ? "" : value.trim();
        }

        private static String decorate(String value) {
            return "*** " + value + " ***";
        }
    }

    public static void main(String[] args) {
        System.out.println(MessageTools.format("  Hello  "));
        System.out.println(MessageTools.format("  Saved  ", "  INFO  "));
    }
}
