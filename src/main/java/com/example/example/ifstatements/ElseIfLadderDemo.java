package com.example.ifstatements;

/** Demonstrates an else-if chain for multiple mutually exclusive choices. */
public class ElseIfLadderDemo {
    public static void main(String[] args) {
        int score = 84;

        if (score < 0 || score > 100) {
            System.out.println("Score is outside the valid range.");
        } else if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else if (score >= 60) {
            System.out.println("Grade: D");
        } else {
            System.out.println("Grade: F");
        }
    }
}
