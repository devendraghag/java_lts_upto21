package com.example.switchstatement;

/** Demonstrates pattern matching and guarded cases in switch statements (final in Java 21). */
public class PatternMatchingSwitchStatementDemo {
    private static void describe(Object value) {
        switch (value) {
            case null -> System.out.println("Value is null");
            case String text when !text.isBlank() ->
                    System.out.println("Nonblank text with " + text.length() + " characters");
            case String text -> System.out.println("Blank text");
            case Integer number when number > 0 -> System.out.println("Positive integer: " + number);
            case Integer number -> System.out.println("Zero or negative integer: " + number);
            default -> System.out.println("Other type: " + value.getClass().getSimpleName());
        }
    }

    public static void main(String[] args) {
        describe("Java 21");
        describe("   ");
        describe(42);
        describe(-3);
        describe(3.14);
        describe(null);
    }
}
