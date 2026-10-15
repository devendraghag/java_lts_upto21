package com.example.switchstatement;

/** Demonstrates arrow labels, multiple labels, and no fall-through (Java 14+). */
public class ArrowSwitchStatementDemo {
    private static void printResponse(int statusCode) {
        switch (statusCode) {
            case 200, 201 -> System.out.println("Success");
            case 400, 401, 403 -> System.out.println("Request or authorization error");
            case 404 -> System.out.println("Resource not found");
            default -> System.out.println("Other response: " + statusCode);
        }
    }

    public static void main(String[] args) {
        printResponse(201);
        printResponse(404);
    }
}
