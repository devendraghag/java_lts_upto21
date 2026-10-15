package com.example.spliterator;
// JDK history: Introduction baseline: JDK 8 (the release bucket for this topic).

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * {@code trySplit()} carves a prefix off the front of the source and returns it as a new
 * {@code Spliterator}, shrinking {@code this} to cover only the remainder. Returning
 * {@code null} means "not splittable any further" &mdash; the caller (typically the
 * fork/join machinery behind a parallel stream) then processes what's left sequentially.
 * <p>Splitting {@code [0, 8)} in half &rarr; {@code root remaining=4, split-off=4}; splitting
 * the {@code [0, 4)} half again &rarr; {@code half1 remaining=2, quarter1=2}.
 */
public class Spliterator04TrySplit {

    static class RangeSpliterator implements Spliterator<Integer> {
        private int start;
        private final int end;

        RangeSpliterator(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            if (start < end) {
                action.accept(start++);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<Integer> trySplit() {
            int remaining = end - start;
            if (remaining < 2) {
                return null;
            }
            int mid = start + remaining / 2;
            Spliterator<Integer> prefix = new RangeSpliterator(start, mid);
            start = mid;
            return prefix;
        }

        @Override
        public long estimateSize() {
            return end - start;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | SUBSIZED | DISTINCT;
        }
    }

    public static void main(String[] args) {
        Spliterator<Integer> root = new RangeSpliterator(0, 8);

        Spliterator<Integer> half1 = root.trySplit();
        System.out.println("root remaining=" + root.estimateSize() + ", split-off=" + half1.estimateSize());

        Spliterator<Integer> quarter1 = half1.trySplit();
        System.out.println("half1 remaining=" + half1.estimateSize() + ", quarter1=" + quarter1.estimateSize());
    }
}
