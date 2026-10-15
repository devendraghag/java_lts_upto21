package com.example.forloop;

/** Demonstrates nested for loops to visit every row and column in a matrix. */
public class NestedForLoopDemo {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print(matrix[row][column] + " ");
            }
            System.out.println();
        }
    }
}
