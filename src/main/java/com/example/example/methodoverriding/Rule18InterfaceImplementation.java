package com.example.example.methodoverriding;

/** Rule 18: implementing an interface supplies an implementation of its instance method. */
public class Rule18InterfaceImplementation {
    interface Greeter { void greet(); }
    static class FriendlyGreeter implements Greeter {
        @Override public void greet() { System.out.println("Welcome"); }
    }
    public static void main(String[] args) { Greeter greeter = new FriendlyGreeter(); greeter.greet(); }
}
