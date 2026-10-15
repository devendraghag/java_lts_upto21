package com.example.statickeyword;

/** Demonstrates static field initialization and a static initialization block. */
public class StaticInitializationBlockDemo {
    public static void main(String[] args) {
        System.out.println("First access: " + Settings.description());
        System.out.println("Second access: " + Settings.description());
    }

    private static final class Settings {
        private static final String APPLICATION;
        private static final int DEFAULT_PORT;

        static {
            System.out.println("Settings static block runs once when the class initializes.");
            APPLICATION = "Example Server";
            DEFAULT_PORT = 8080;
        }

        private static String description() {
            return APPLICATION + " listens on " + DEFAULT_PORT;
        }
    }
}
