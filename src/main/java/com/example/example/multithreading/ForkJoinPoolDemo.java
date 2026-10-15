package com.example.multithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/** Demonstrates divide-and-conquer work using the fork/join framework. */
public class ForkJoinPoolDemo {
    private static final int THRESHOLD = 1_000;

    public static void main(String[] args) {
        long sum = ForkJoinPool.commonPool().invoke(new RangeSum(1, 100_000));
        System.out.println("Sum from 1 to 100000: " + sum);
    }

    private static final class RangeSum extends RecursiveTask<Long> {
        private final int start;
        private final int end;

        private RangeSum(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int number = start; number <= end; number++) sum += number;
                return sum;
            }
            int middle = (start + end) >>> 1;
            RangeSum left = new RangeSum(start, middle);
            RangeSum right = new RangeSum(middle + 1, end);
            left.fork();
            long rightResult = right.compute();
            return left.join() + rightResult;
        }
    }
}
