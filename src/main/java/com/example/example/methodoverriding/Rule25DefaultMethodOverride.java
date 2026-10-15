package com.example.example.methodoverriding;

/** Rule 25: a class can override an interface default method. */
public class Rule25DefaultMethodOverride {
    interface Logger { default void log() { System.out.println("Default log"); } }
    static class CustomLogger implements Logger { @Override public void log() { System.out.println("Custom log"); } }
    public static void main(String[] args) { new CustomLogger().log(); }
}
