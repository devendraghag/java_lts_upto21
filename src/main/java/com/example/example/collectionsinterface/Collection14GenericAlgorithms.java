package com.example.collectionsinterface;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/** Advanced: write reusable algorithms against Collection rather than one implementation. */
public class Collection14GenericAlgorithms {
    public static void main(String[] args) {
        Collection<Integer> numbers = List.of(12, 5, 18, 7, 20, 3);
        List<Integer> largeNumbers = select(numbers, number -> number >= 10);
        long oddCount = countMatching(numbers, number -> number % 2 != 0);

        System.out.println("Numbers at least 10: " + largeNumbers);
        System.out.println("Count of odd numbers: " + oddCount);
    }

    private static <T> List<T> select(Collection<? extends T> source, Predicate<? super T> condition) {
        List<T> matches = new ArrayList<>();
        for (T element : source) {
            if (condition.test(element)) {
                matches.add(element);
            }
        }
        return matches;
    }

    private static <T> long countMatching(Collection<T> source, Predicate<? super T> condition) {
        return source.stream().filter(condition).count();
    }
}