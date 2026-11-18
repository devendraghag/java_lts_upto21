package com.example.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/** Explains Collection's three methods that work with a whole group of items. */
public class Collection06BulkOperations {
    public static void main(String[] args) {
        Collection<String> selected = new ArrayList<>(List.of("red", "blue"));
        boolean added = selected.addAll(List.of("green", "yellow"));
        System.out.println("addAll: added all items from the given collection; changed=" + added);
        System.out.println("After addAll: " + selected);

        boolean removed = selected.removeAll(List.of("blue", "yellow"));
        System.out.println("removeAll: removed items also present in the given collection; changed=" + removed);
        System.out.println("After removeAll: " + selected);

        selected.addAll(List.of("blue", "yellow"));
        boolean retained = selected.retainAll(List.of("red", "green"));
        System.out.println("retainAll: kept only items also present in the given collection; changed=" + retained);
        System.out.println("After retainAll: " + selected);
    }
}
