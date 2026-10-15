package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.Delayed;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/** Level 5: DelayQueue makes an element available only after its delay expires. */
public class BlockingQueue05DelayQueue {
    record DelayedTask(String name, long readyAtNanos) implements Delayed {
        static DelayedTask after(String name, long delay, TimeUnit unit) {
            return new DelayedTask(name, System.nanoTime() + unit.toNanos(delay));
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(readyAtNanos - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            return Long.compare(
                    getDelay(TimeUnit.NANOSECONDS),
                    other.getDelay(TimeUnit.NANOSECONDS));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        queue.put(DelayedTask.after("later", 250, TimeUnit.MILLISECONDS));
        queue.put(DelayedTask.after("sooner", 100, TimeUnit.MILLISECONDS));

        System.out.println(queue.take().name()); // sooner
        System.out.println(queue.take().name()); // later
    }
}