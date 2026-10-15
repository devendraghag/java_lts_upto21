package com.example.streamcreation;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.StreamSupport;

/** Creates a stream from a custom Spliterator using StreamSupport. */
public class StreamSupportSpliteratorDemo {
    public static void main(String[] args) {
        Spliterator<Integer> numbers = new RangeSpliterator(1, 11);

        StreamSupport.stream(numbers, true)
                .map(number -> number * number)
                .forEachOrdered(System.out::println);
    }

    /** Splits an integer range into ordered, sized parts. */
    private static final class RangeSpliterator implements Spliterator<Integer> {
        private int current;
        private final int fence;

        private RangeSpliterator(int current, int fence) {
            this.current = current;
            this.fence = fence;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Integer> action) {
            if (action == null) {
                throw new NullPointerException("action");
            }
            if (current >= fence) {
                return false;
            }
            action.accept(current++);
            return true;
        }

        @Override
        public Spliterator<Integer> trySplit() {
            int midpoint = current + (fence - current) / 2;
            if (midpoint <= current) {
                return null;
            }

            int oldCurrent = current;
            current = midpoint;
            return new RangeSpliterator(oldCurrent, midpoint);
        }

        @Override
        public long estimateSize() {
            return fence - current;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | SUBSIZED | IMMUTABLE | NONNULL;
        }
    }
}
