package com.example.collectionclasses.linkedblockingdeque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

public class LinkedBlockingDequeDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque<String> deque = new LinkedBlockingDeque<>(4);
        deque.putFirst("front");
        deque.putLast("back");
        deque.offerFirst("new-front");
        deque.offerLast("tail");
        System.out.println("Remaining capacity: " + deque.remainingCapacity());

        for (String value : deque) {
            System.out.println("Forward: " + value);
        }
        Iterator<String> reverse = deque.descendingIterator();
        while (reverse.hasNext()) {
            System.out.println("Reverse: " + reverse.next());
        }

        System.out.println("ArrayList conversion: " + new ArrayList<>(deque));
        System.out.println("Take last: " + deque.takeLast());
        System.out.println("Peek first / last: " + deque.peekFirst() + " / " + deque.peekLast());
        // JDK 21 SequencedCollection reversed() provides a live reverse-order view.
        System.out.println("JDK 21 reverse view: " + deque.reversed());
        deque.drainTo(new ArrayList<>());
        System.out.println("Empty after drainTo: " + deque.isEmpty());
    }
}
