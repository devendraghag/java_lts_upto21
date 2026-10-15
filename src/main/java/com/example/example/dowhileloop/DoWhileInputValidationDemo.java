package com.example.dowhileloop;

import java.util.Scanner;

/** Repeats until the user enters an integer in the inclusive range 1 through 10. */
public class DoWhileInputValidationDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = 0;
        boolean valid;

        do {
            System.out.print("Enter a whole number from 1 to 10: ");
            valid = false;

            if (!scanner.hasNext()) {
                System.out.println("No more input was provided.");
                return;
            }
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                valid = value >= 1 && value <= 10;
                if (!valid) {
                    System.out.println("The number must be between 1 and 10.");
                }
            } else {
                System.out.println("That is not an integer. Try again.");
                scanner.next(); // Discard the invalid token so the loop can continue.
            }
        } while (!valid);

        System.out.println("Accepted value: " + value);
    }
}
