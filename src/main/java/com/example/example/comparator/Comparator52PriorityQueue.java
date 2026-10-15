package com.example.comparator;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Comparator52PriorityQueue {
    record Task(String name, int priority) {}

    public static void main(String[] args) {
        Comparator<Task> urgentFirst = Comparator.comparingInt(Task::priority)
                .reversed()
                .thenComparing(Task::name);
        PriorityQueue<Task> tasks = new PriorityQueue<>(urgentFirst);
        tasks.add(new Task("report", 2));
        tasks.add(new Task("incident", 5));
        tasks.add(new Task("backup", 3));

        // Each poll asks the queue for its current head according to the comparator.
        while (!tasks.isEmpty()) {
            System.out.println(tasks.poll());
        }
    }
}
