package com.example.continuestatement;

/** Uses continue to skip selected iterations of a traditional for loop. */
public class ContinueForLoopDemo {
    public static void main(String[] args) {
        System.out.println("Odd numbers from 1 through 10:");
        for (int number = 1; number <= 10; number++) {
            if (number % 2 == 0) {
                continue; // The for-loop update still runs before the next condition check.
            }
            System.out.println(number);
        }
    }
}
