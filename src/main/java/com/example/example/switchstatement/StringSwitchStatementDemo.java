package com.example.switchstatement;

/** Demonstrates switching on String values (supported since Java 7). */
public class StringSwitchStatementDemo {
    public static void main(String[] args) {
        String command = "save";

        switch (command) {
            case "open":
                System.out.println("Opening document");
                break;
            case "save":
                System.out.println("Saving document");
                break;
            case "close":
                System.out.println("Closing document");
                break;
            default:
                System.out.println("Unknown command");
                break;
        }
    }
}
