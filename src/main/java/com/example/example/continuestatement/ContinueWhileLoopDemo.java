package com.example.continuestatement;

/** Uses continue in a while loop, updating before the possible continue. */
public class ContinueWhileLoopDemo {
    public static void main(String[] args) {
        int number = 0;
        while (number < 8) {
            number++; // Update first so continue cannot accidentally create an infinite loop.
            if (number % 3 == 0) {
                continue;
            }
            System.out.println(number);
        }
    }
}
