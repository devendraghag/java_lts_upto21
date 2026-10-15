package com.example.dowhileloop;

/** Basic do-while syntax and the guaranteed first iteration. */
public class DoWhileBasicsDemo {
    public static void main(String[] args) {
        int attempts = 0;
        do {
            attempts++;
            System.out.println("Attempt " + attempts);
        } while (attempts < 3); // The semicolon after while is required.

        int runOnce = 0;
        do {
            runOnce++;
            System.out.println("This runs even though the condition is initially false");
        } while (runOnce < 0);
    }
}
