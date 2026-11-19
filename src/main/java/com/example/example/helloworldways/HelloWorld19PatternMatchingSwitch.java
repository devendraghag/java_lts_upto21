package com.example.example.helloworldways;

/** Java 21: matches different greeting input types in a switch expression. */
public class HelloWorld19PatternMatchingSwitch {
    public static void main(String[] args) {
        Object input = args.length == 0 ? "World" : args;
        String name = switch (input) {
            case String value -> value;
            case String[] values when values.length > 0 -> String.join(" ", values);
            case String[] values -> "World";
            default -> "World";
        };
        System.out.println("Hello, " + name + "!");
    }
}
