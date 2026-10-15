package com.example.forloop;

/** Demonstrates multiple loop variables, continue, and omitted clauses. */
public class ForLoopVariationsDemo {
    public static void main(String[] args) {
        System.out.println("Two counters in one loop:");
        for (int left = 1, right = 5; left <= right; left++, right--) {
            System.out.println("left=" + left + ", right=" + right);
        }

        System.out.println("Skip even values with continue:");
        for (int number = 1; number <= 7; number++) {
            if (number % 2 == 0) {
                continue;
            }
            System.out.println(number);
        }

        System.out.println("Loop with update handled inside the body:");
        int step = 0;
        for (; step < 3; ) {
            System.out.println("step=" + step);
            step++;
        }
    }
}
