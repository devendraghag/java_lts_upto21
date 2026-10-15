package com.example.interfacestaticmethods;

import java.util.List;

/** Demonstrates a generic static method declared in an interface. */
public class GenericInterfaceStaticMethodDemo {
    private interface CollectionTools {
        static <T> List<T> singleton(T value) {
            return List.of(value);
        }

        static <T> void printAll(Iterable<T> values) {
            for (T value : values) {
                System.out.println(value);
            }
        }
    }

    public static void main(String[] args) {
        List<String> names = CollectionTools.singleton("Maya");
        List<Integer> scores = CollectionTools.singleton(98);

        CollectionTools.printAll(names);
        CollectionTools.printAll(scores);
    }
}
