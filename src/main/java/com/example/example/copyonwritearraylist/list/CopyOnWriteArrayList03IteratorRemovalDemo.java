package com.example.copyonwritearraylist.list;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/** Shows that snapshot iterators do not support remove(). */
public class CopyOnWriteArrayList03IteratorRemovalDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> tools = new CopyOnWriteArrayList<>();
        tools.add("compiler");
        tools.add("debugger");

        Iterator<String> iterator = tools.iterator();
        System.out.println("Next tool: " + iterator.next());

        // Iterator.remove() is unsupported by CopyOnWriteArrayList snapshot iterators.
        try {
            iterator.remove();
        } catch (UnsupportedOperationException exception) {
            System.out.println("Cannot remove through the snapshot iterator.");
        }

        // Remove directly from the list instead. This creates a new backing array.
        tools.remove("compiler");
        System.out.println("List after direct removal: " + tools);
    }
}
