package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * JDK 21 BlockingQueue ladder (06/15): DelayQueue for time-gated jobs.
 *
 * DelayQueue only releases an element from take()/poll() once its delay has expired.
 * Elements must implement Delayed, exposing remaining time and a natural ordering.
 */
/**
 * Easy: Demonstrates a record implementing Delayed becoming available only after its delay elapses.
 * Medium: Track how take() blocks until the earliest-expiring job is ready.
 * Tough: Explain why compareTo() must agree with getDelay() to keep the head deterministic.
 */
public class BlockingQueue06DelayQueueScheduledJobs {

    record DelayedJob(String name, long readyAtNanos) implements Delayed {
        static DelayedJob in(String name, long delayMillis) {
            return new DelayedJob(name, System.nanoTime() + TimeUnit.MILLISECONDS.toNanos(delayMillis));
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(readyAtNanos - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            return Long.compare(this.getDelay(TimeUnit.NANOSECONDS), other.getDelay(TimeUnit.NANOSECONDS));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayedJob> queue = new DelayQueue<>();

        queue.put(DelayedJob.in("slow-job", 300));
        queue.put(DelayedJob.in("fast-job", 50));
        queue.put(DelayedJob.in("medium-job", 150));

        System.out.println("Submitted three jobs with different delays; take() honors readiness, not insertion order.");
        for (int i = 0; i < 3; i++) {
            long start = System.nanoTime();
            DelayedJob job = queue.take();
            long waitedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - start);
            System.out.println("  Took " + job.name() + " after waiting ~" + waitedMillis + "ms");
        }
    }
}
