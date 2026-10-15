package com.example.foreachloop;

/** Demonstrates enhanced for loops over primitive and reference arrays. */
public class ArrayForEachLoopDemo {
    public static void main(String[] args) {
        int[] scores = {82, 94, 76};
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        System.out.println("Average score: " + (total / scores.length));

        String[] names = {"Asha", "Ravi", "Maya"};
        for (String name : names) {
            System.out.println(name);
        }
    }
}
