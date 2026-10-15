package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** MEDIUM 10/17: Define an unchecked exception for an invalid method argument. */
class InvalidQuantityException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    InvalidQuantityException(String message) {
        super(message);
    }
}

public class ExceptionHandling10CustomUncheckedException {
    private static void orderItems(int quantity) {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than zero.");
        }
        System.out.println("Ordered " + quantity + " item(s).");
    }

    public static void main(String[] args) {
        try {
            orderItems(0);
        } catch (InvalidQuantityException exception) {
            // Catching is optional for RuntimeException, but allowed.
            System.out.println("Order rejected: " + exception.getMessage());
        }
    }
}
