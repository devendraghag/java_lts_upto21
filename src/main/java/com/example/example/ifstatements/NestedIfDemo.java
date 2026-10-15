package com.example.ifstatements;

/** Demonstrates an if statement inside another if statement. */
public class NestedIfDemo {
    public static void main(String[] args) {
        boolean accountActive = true;
        double balance = 1250.00;
        double withdrawal = 300.00;

        if (accountActive) {
            if (withdrawal > 0 && withdrawal <= balance) {
                System.out.println("Withdrawal approved.");
            } else {
                System.out.println("Invalid amount or insufficient balance.");
            }
        } else {
            System.out.println("Account is inactive.");
        }
    }
}
