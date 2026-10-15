package com.example.ifstatements;

/** Demonstrates choosing one of two branches with if-else. */
public class IfElseDemo {
    public static void main(String[] args) {
        int number = 18;

        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }
    }
}
