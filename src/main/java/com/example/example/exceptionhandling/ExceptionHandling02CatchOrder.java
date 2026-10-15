package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** EASY 2/17: Put the most specific catch before its superclass catch. */
public class ExceptionHandling02CatchOrder {
    public static void main(String[] args) {
        String text = "not a number";

        try {
            int value = Integer.parseInt(text);
            System.out.println("Value: " + value);
        } catch (NumberFormatException exception) {
            System.out.println("The text is not a valid integer.");
        } catch (IllegalArgumentException exception) {
            // NumberFormatException is a subtype of IllegalArgumentException.
            // This broader catch can handle other illegal arguments.
            System.out.println("An argument was invalid.");
        } catch (Exception exception) {
            // Broad catches belong after more specific catches.
            System.out.println("Another exception occurred.");
        }
    }
}
