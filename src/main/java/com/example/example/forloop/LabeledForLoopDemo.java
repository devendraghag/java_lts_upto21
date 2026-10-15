package com.example.forloop;

/** Demonstrates labeled continue and break for nested loops. */
public class LabeledForLoopDemo {
    public static void main(String[] args) {
        int[][] values = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int target = 5;
        search:
        for (int row = 0; row < values.length; row++) {
            for (int column = 0; column < values[row].length; column++) {
                if (values[row][column] == 2) {
                    continue search; // Move to the next row.
                }
                if (values[row][column] == target) {
                    System.out.println("Found " + target + " at row " + row
                            + ", column " + column);
                    break search; // Exit both loops.
                }
            }
        }
    }
}
