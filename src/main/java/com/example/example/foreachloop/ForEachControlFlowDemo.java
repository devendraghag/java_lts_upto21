package com.example.foreachloop;

import java.util.List;

/** Demonstrates continue and break in an enhanced for loop. */
public class ForEachControlFlowDemo {
    public static void main(String[] args) {
        List<Integer> values = List.of(3, 8, 11, 14, 20);

        for (int value : values) {
            if (value % 2 != 0) {
                continue; // Skip odd values.
            }
            if (value > 15) {
                break; // Stop the loop at the first even value above 15.
            }
            System.out.println("Processed: " + value);
        }
    }
}
