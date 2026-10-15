package level03_advanced.jdk21.sequencedcollections.sequencedcollections;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

import java.util.ArrayDeque;
import java.util.SequencedCollection;

/** Level 3: ArrayDeque also implements SequencedCollection and supports both ends. */
public class SequencedCollection03ArrayDequeEndpoints {
    public static void main(String[] args) {
        SequencedCollection<String> tasks = new ArrayDeque<>();
        tasks.addLast("normal task");
        tasks.addFirst("urgent task");
        tasks.addLast("later task");

        System.out.println(tasks);            // [urgent task, normal task, later task]
        System.out.println(tasks.getFirst());  // urgent task
        System.out.println(tasks.removeFirst()); // urgent task
        System.out.println(tasks);            // [normal task, later task]
    }
}
