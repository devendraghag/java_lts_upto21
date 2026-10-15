package com.example.unmodifiable.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Shows that the wrapper can contain null when its source list allows null. */
public class UnmodifiableList03NullElementsDemo {
    public static void main(String[] args) {
        List<String> source = new ArrayList<>();
        source.add("Java");
        source.add(null);

        // unmodifiableList() wraps the source; it does not validate or remove
        // the source's existing null elements.
        List<String> view = Collections.unmodifiableList(source);

        System.out.println("View containing a null element: " + view);
        System.out.println("Element at index 1 is null: " + (view.get(1) == null));
    }
}
