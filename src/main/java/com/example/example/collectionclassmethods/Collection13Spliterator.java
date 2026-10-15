package com.example.collectionclassmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Spliterator;

/** Advanced: split and traverse a Collection using its Spliterator. */
public class Collection13Spliterator {
    public static void main(String[] args) {
        Collection<String> subjects = new ArrayList<>(List.of("math", "science", "history", "art"));
        Spliterator<String> remaining = subjects.spliterator();
        Spliterator<String> firstPart = remaining.trySplit();

        if (firstPart == null) {
            System.out.println("The spliterator could not be split.");
            return;
        }

        System.out.println("First part:");
        firstPart.forEachRemaining(System.out::println);
        System.out.println("Remaining part:");
        remaining.forEachRemaining(System.out::println);
    }
}