package com.example.example.helloworldways;

/** Uses command-line arguments as the name; falls back to World. */
public class HelloWorld10CommandLineName {
    public static void main(String[] args) {
        String name = args.length == 0 ? "World" : String.join(" ", args);
        System.out.println("Hello, " + name + "!");
    }
}
