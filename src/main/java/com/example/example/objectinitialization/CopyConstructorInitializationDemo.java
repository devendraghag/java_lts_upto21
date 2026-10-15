package com.example.objectinitialization;

/** Demonstrates a copy constructor and independent mutable state. */
public class CopyConstructorInitializationDemo {
    private static final class Player {
        private String name;
        private int score;

        private Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        private Player(Player source) {
            this(source.name, source.score);
        }
    }

    public static void main(String[] args) {
        Player original = new Player("Ravi", 12);
        Player copy = new Player(original);
        copy.score = 20;

        System.out.println("Original score: " + original.score);
        System.out.println("Copied score: " + copy.score);
    }
}
