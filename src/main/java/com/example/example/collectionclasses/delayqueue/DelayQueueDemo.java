package com.example.collectionclasses.delayqueue;

import java.util.ArrayList;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    private static final class DelayedTask implements Delayed {
        private final String name;
        private final long readyAt;

        private DelayedTask(String name, long delay, TimeUnit unit) {
            this.name = name;
            this.readyAt = System.nanoTime() + unit.toNanos(delay);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(readyAt - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed other) {
            if (other instanceof DelayedTask task) {
                return Long.compare(readyAt, task.readyAt); // Compare fixed deadlines, not changing delays.
            }
            return Long.compare(getDelay(TimeUnit.NANOSECONDS), other.getDelay(TimeUnit.NANOSECONDS));
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        queue.put(new DelayedTask("ready-now", 0, TimeUnit.MILLISECONDS));
        queue.put(new DelayedTask("ready-later", 1, TimeUnit.MILLISECONDS));
        queue.put(new DelayedTask("ready-later", 2, TimeUnit.MILLISECONDS));
        System.out.println("Queue size: " + queue.size());

        for (DelayedTask task : queue) {
            System.out.println("Queued: " + task);
        }

        System.out.println("ArrayList snapshot: " + new ArrayList<>(queue));
        System.out.println("Take after delay: " + queue.take());
        System.out.println("Next: " + queue.take());
        System.out.println("Poll on empty queue (does not wait): " + queue.poll());
        System.out.println("Empty: " + queue.isEmpty());
        // take blocks until the head task's delay reaches zero; poll never waits.
    }
}
