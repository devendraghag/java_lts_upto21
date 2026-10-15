package com.example.example.methodoverriding;

import java.io.IOException;

/** Rule 8: an override may declare fewer or narrower checked exceptions. */
public class Rule08CheckedExceptionsNarrow {
    static class Parent { void load() throws IOException { System.out.println("Parent load"); } }
    static class Child extends Parent { @Override void load() { System.out.println("Child load"); } }
    public static void main(String[] args) throws IOException { new Child().load(); }
}
