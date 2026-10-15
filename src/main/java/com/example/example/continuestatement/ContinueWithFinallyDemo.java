package com.example.continuestatement;

/** Shows that a finally block runs when continue leaves a try block. */
public class ContinueWithFinallyDemo {
    public static void main(String[] args) {
        for (int number = 1; number <= 3; number++) {
            try {
                if (number == 2) {
                    System.out.println("Skipping body for " + number);
                    continue;
                }
                System.out.println("Loop body for " + number);
            } finally {
                System.out.println("Finally runs for " + number);
            }
        }
    }
}
