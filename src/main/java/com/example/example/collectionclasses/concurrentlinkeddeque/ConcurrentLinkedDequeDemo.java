package com.example.collectionclasses.concurrentlinkeddeque;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ConcurrentLinkedDequeDemo {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> deque = new ConcurrentLinkedDeque<>();
        deque.addFirst("middle");
        deque.addFirst("front");
        deque.addLast("back");
        deque.offerFirst("urgent");
        deque.offerLast("tail");

        for (String value : deque) {
            System.out.println("Forward: " + value);
        }
        for (var iterator = deque.descendingIterator(); iterator.hasNext();) {
            System.out.println("Reverse: " + iterator.next());
        }

        System.out.println("ArrayList snapshot: " + new ArrayList<>(deque));
        System.out.println("Remove first: " + deque.pollFirst());
        System.out.println("Peek last: " + deque.peekLast());
        System.out.println("Remove last occurrence of middle: " + deque.removeLastOccurrence("middle"));
        // JDK 21 SequencedCollection reversed() supplies a reverse-order live view.
        System.out.println("JDK 21 reverse view: " + deque.reversed());
    }
}
