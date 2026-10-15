package com.example.blockingqueue;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * JDK 21 BlockingQueue ladder (05/15): PriorityBlockingQueue with a record.
 *
 * PriorityBlockingQueue is an unbounded blocking queue that reorders elements by
 * a Comparable/Comparator instead of insertion order. take() always returns the
 * highest-priority element currently present.
 */
/**
 * Easy: Demonstrates a record implementing Comparable driving PriorityBlockingQueue ordering.
 * Medium: Track how insertion order and poll order diverge based on priority value.
 * Tough: Explain why elements with equal priority have no guaranteed relative order.
 */
public class BlockingQueue05PriorityOrderingRecord {

    record Task(int priority, String name) implements Comparable<Task> {
        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Task> queue = new PriorityBlockingQueue<>();

        queue.put(new Task(5, "send-report"));
        queue.put(new Task(1, "page-oncall"));
        queue.put(new Task(3, "refresh-cache"));
        queue.put(new Task(2, "rotate-logs"));

        System.out.println("Inserted out of priority order, draining lowest-priority-number first:");
        while (!queue.isEmpty()) {
            System.out.println("  " + queue.take());
        }
    }
}
