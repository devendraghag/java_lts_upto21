package com.example.comparable;

import java.util.*;

public class Comparable43PriorityQueueNaturalOrder {
    record Job(String name, int priority) implements Comparable<Job> {
        public int compareTo(Job o) {
            return Integer.compare(priority, o.priority);
        }
    }

    public static void main(String[] x) {
        PriorityQueue<Job> q = new PriorityQueue<>();
        q.add(new Job("low", 3));
        q.add(new Job("urgent", 1));
        q.add(new Job("normal", 2));
        while (!q.isEmpty())System.out.println(q.poll());
        // Natural order puts the least item at the head.
    }
}
