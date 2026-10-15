package com.example.ifstatements;

/** Shows safe null guarding through left-to-right short-circuit evaluation. */
public class IfGuardAndShortCircuitDemo {
    public static void main(String[] args) {
        String input = "Java";

        if (input != null && !input.isEmpty()) {
            System.out.println("First character: " + input.charAt(0));
        } else {
            System.out.println("Input is null or empty.");
        }

        int age = 20;
        boolean hasTicket = true;
        if (age >= 18 && hasTicket) {
            System.out.println("Entry allowed.");
        }
    }
}
