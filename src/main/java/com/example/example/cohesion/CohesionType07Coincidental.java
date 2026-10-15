package com.example.cohesion;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Coincidental cohesion: unrelated jobs have been placed in one class without
 * a useful relationship. This is an example to recognize and improve.
 */
public class CohesionType07Coincidental {
    static class GeneralUtilityBox {
        String makeUpperCase(String text) {
            return text.toUpperCase();
        }

        double calculateTax(double amount) {
            return amount * 0.10;
        }

        void printWelcomeMessage() {
            System.out.println("Welcome to the application");
        }
    }

    public static void main(String[] args) {
        GeneralUtilityBox box = new GeneralUtilityBox();
        System.out.println(box.makeUpperCase("hello"));
        System.out.println("Tax: " + box.calculateTax(50.0));
        box.printWelcomeMessage();
        System.out.println("These unrelated tasks would be clearer in separate classes.");
    }
}
