package com.example.example.helloworldways;

/** Java 14: chooses the greeting with a switch expression. */
public class HelloWorld18SwitchExpression {
    public static void main(String[] args) {
        String language = args.length == 0 ? "English" : args[0];
        String message = switch (language) {
            case "English" -> "Hello, World!";
            case "French" -> "Bonjour, le monde!";
            case "Spanish" -> "¡Hola, mundo!";
            default -> "Hello, World! (language: " + language + ")";
        };
        System.out.println(message);
    }
}
