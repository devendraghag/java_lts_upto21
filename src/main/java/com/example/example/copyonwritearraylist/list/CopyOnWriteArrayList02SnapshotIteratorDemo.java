package com.example.copyonwritearraylist.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/** Shows that an iterator reads a snapshot of the list at iterator creation time. */
public class CopyOnWriteArrayList02SnapshotIteratorDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> names = new CopyOnWriteArrayList<>();
        names.add("Asha");
        names.add("Ravi");

        // This iterator keeps the array snapshot that exists at this point.
        Iterator<String> snapshotIterator = names.iterator();

        // A write creates a new backing array; it does not change the iterator's snapshot.
        names.add("Mina");

        System.out.println("Current list: " + names);
        System.out.print("Iterator snapshot: ");
        while (snapshotIterator.hasNext()) {
            System.out.print(snapshotIterator.next() + " ");
        }
        System.out.println();
    }
}
