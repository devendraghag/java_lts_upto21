package com.example.comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Comparator51PriorityQueueComparator {
    record Job(int priority, String id) {}

    public static void main(String[] args) {
        // This queue needs urgent (larger priority) jobs first, so the priority key is reversed.
        Comparator<Job> urgentFirst = Comparator.comparingInt(Job::priority)
                .reversed()
                .thenComparing(Job::id);
        PriorityQueue<Job> jobs = new PriorityQueue<>(urgentFirst);
        jobs.add(new Job(3, "C"));
        jobs.add(new Job(1, "A"));
        jobs.add(new Job(2, "B"));

        while (!jobs.isEmpty()) {
            System.out.println(jobs.poll());
        }
    }
}
