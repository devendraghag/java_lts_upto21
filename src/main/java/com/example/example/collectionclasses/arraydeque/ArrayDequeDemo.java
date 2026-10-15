package com.example.collectionclasses.arraydeque;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.addFirst("middle");
        deque.addFirst("front");
        deque.addLast("back");
        deque.offerFirst("urgent"); // Non-throwing deque insertion variant.
        deque.offerLast("tail");

        for (String value : deque) {
            System.out.println("Front to back: " + value);
        }
        Iterator<String> reverse = deque.descendingIterator();
        while (reverse.hasNext()) {
            System.out.println("Back to front: " + reverse.next());
        }

        System.out.println("Queue removal: " + deque.removeFirst());
        System.out.println("Stack removal: " + deque.removeLast());
        System.out.println("List conversion: " + new ArrayList<>(deque));
        System.out.println("Array: " + java.util.Arrays.toString(deque.toArray(String[]::new)));
        System.out.println("Peek first / last: " + deque.peekFirst() + " / " + deque.peekLast());
        // JDK 21 SequencedCollection view supports encounter-order reverse traversal.
        System.out.println("JDK 21 reverse view: " + deque.reversed());
        System.out.println("Remove last occurrence of middle: " + deque.removeLastOccurrence("middle"));
    }
}
