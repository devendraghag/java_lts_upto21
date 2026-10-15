package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** EASY 3/17: Handle different operations with separate catch blocks. */
public class ExceptionHandling03SeparateCatchBlocks {
    public static void main(String[] args) {
        try {
            int[] scores = { 70, 85, 92 };
            System.out.println("First score: " + scores[0]);
            System.out.println("Requested score: " + scores[5]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("That score position does not exist.");
        } catch (NullPointerException exception) {
            System.out.println("The scores array was not created.");
        }

        System.out.println("Finished handling the score request.");
    }
}
