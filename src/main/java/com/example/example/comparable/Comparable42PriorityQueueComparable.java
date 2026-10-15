package com.example.comparable;

import java.util.PriorityQueue;

public class Comparable42PriorityQueueComparable {
    record Job(int priority, String id) implements Comparable<Job> {
        @Override
        public int compareTo(Job other) {
            int byPriority = Integer.compare(priority, other.priority);
            return byPriority != 0 ? byPriority : id.compareTo(other.id);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Job> jobs = new PriorityQueue<>();
        jobs.add(new Job(3, "C"));
        jobs.add(new Job(1, "A"));
        jobs.add(new Job(2, "B"));

        // Polling a PriorityQueue repeatedly follows the natural ordering at its head.
        while (!jobs.isEmpty()) {
            System.out.println(jobs.poll());
        }
    }
}
