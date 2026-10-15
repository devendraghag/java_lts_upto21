package com.example.staticinitializationblock;

/** Demonstrates a static initialization block assigning a blank static final field. */
public class BasicStaticInitializationBlockDemo {
    private static final String APPLICATION_NAME;

    static {
        APPLICATION_NAME = "Java SIB Demo";
        System.out.println("Static block initialized APPLICATION_NAME");
    }

    public static void main(String[] args) {
        System.out.println(APPLICATION_NAME);
    }
}
