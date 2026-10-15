package com.example.foreachloop;

import java.util.Iterator;
import java.util.List;

/** Demonstrates a user-defined Iterable used by an enhanced for loop. */
public class CustomIterableForEachLoopDemo {
    private static final class ScoreBoard implements Iterable<Integer> {
        private final List<Integer> scores;

        private ScoreBoard(List<Integer> scores) {
            this.scores = List.copyOf(scores);
        }

        @Override
        public Iterator<Integer> iterator() {
            return scores.iterator();
        }
    }

    public static void main(String[] args) {
        ScoreBoard board = new ScoreBoard(List.of(88, 91, 79));
        for (int score : board) {
            System.out.println("Score: " + score);
        }
    }
}
