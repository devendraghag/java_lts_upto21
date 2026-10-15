package com.example.collectionclassmethods;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/** Advanced: implement a small mutable collection by extending AbstractCollection. */
public class Collection15CustomAbstractCollection {
    public static void main(String[] args) {
        Collection<String> tags = new TagCollection();
        tags.add("java");
        tags.add("collections");
        tags.add("java");

        System.out.println("Tags: " + tags);
        System.out.println("Contains collections: " + tags.contains("collections"));
        tags.remove("java");
        System.out.println("After removing one java tag: " + tags);
    }

    private static final class TagCollection extends AbstractCollection<String> {
        private final ArrayList<String> elements = new ArrayList<>();

        @Override
        public Iterator<String> iterator() {
            return elements.iterator();
        }

        @Override
        public int size() {
            return elements.size();
        }

        @Override
        public boolean add(String element) {
            elements.add(Objects.requireNonNull(element, "element"));
            return true;
        }
    }
}