package com.example.forloop;

/** Demonstrates the traditional three-part for loop and reverse iteration. */
public class BasicForLoopDemo {
    public static void main(String[] args) {
        System.out.println("Count upward:");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("Walk through an array by index in reverse:");
        String[] days = {"Monday", "Tuesday", "Wednesday"};
        for (int i = days.length - 1; i >= 0; i--) {
            System.out.println(days[i]);
        }
    }
}
