package com.example.continuestatement;

/** Compares unlabeled continue with labeled continue in nested loops. */
public class LabeledContinueDemo {
    public static void main(String[] args) {
        System.out.println("Unlabeled continue skips to the next column:");
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                if (column == 2) {
                    continue; // Targets only the innermost loop.
                }
                System.out.println("(" + row + ", " + column + ")");
            }
        }

        System.out.println("Labeled continue skips to the next row:");
        rows:
        for (int row = 1; row <= 3; row++) {
            for (int column = 1; column <= 3; column++) {
                if (column == 2) {
                    continue rows; // Targets the labeled outer loop.
                }
                System.out.println("(" + row + ", " + column + ")");
            }
        }
    }
}
