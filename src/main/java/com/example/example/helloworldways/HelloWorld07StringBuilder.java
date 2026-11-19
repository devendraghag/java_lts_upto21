package com.example.example.helloworldways;

/** Uses StringBuilder to assemble a message in steps. */
public class HelloWorld07StringBuilder {
    public static void main(String[] args) {
        String message = new StringBuilder().append("Hello").append(", ").append("World").append('!').toString();
        System.out.println(message);
    }
}
