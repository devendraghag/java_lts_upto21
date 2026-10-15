package com.example.generics;

/** Demonstrates a generic constructor in a non-generic class. */
public class GenericConstructorDemo {
    private static final class Description {
        private final String text;

        private <T> Description(T source) {
            text = "Value " + source + " has type " + source.getClass().getSimpleName();
        }

        @Override
        public String toString() {
            return text;
        }
    }

    public static void main(String[] args) {
        Description fromText = new Description("hello");
        Description fromNumber = new <Integer>Description(21);

        System.out.println(fromText);
        System.out.println(fromNumber);
    }
}
