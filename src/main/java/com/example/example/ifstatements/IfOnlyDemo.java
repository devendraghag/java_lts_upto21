package com.example.ifstatements;

/** Demonstrates a simple if statement with no else branch. */
public class IfOnlyDemo {
    public static void main(String[] args) {
        int temperature = 31;

        if (temperature > 30) {
            System.out.println("It is a hot day.");
        }

        System.out.println("This line runs whether or not the condition was true.");
    }
}
