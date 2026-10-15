package com.example.dowhileloop;

/** Nested do-while loops to print a small multiplication table. */
public class NestedDoWhileDemo {
    public static void main(String[] args) {
        int row = 1;
        do {
            int column = 1;
            do {
                System.out.printf("%4d", row * column);
                column++;
            } while (column <= 4);
            System.out.println();
            row++;
        } while (row <= 3);
    }
}
