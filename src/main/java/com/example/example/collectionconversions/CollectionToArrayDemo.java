package com.example.collectionconversions;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

/** Collection (List or Set) to array conversions. */
public class CollectionToArrayDemo {
    public static void main(String[] args) {
        List<String> courses = List.of("Java", "Spring", "SQL");
        String[] fromList = courses.toArray(String[]::new);
        Object[] objects = courses.toArray();
        String[] olderStyle = courses.toArray(new String[0]);

        Set<String> courseSet = new LinkedHashSet<>(courses);
        String[] fromSet = courseSet.toArray(String[]::new);

        System.out.println("List to String[]: " + Arrays.toString(fromList));
        System.out.println("List to Object[]: " + Arrays.toString(objects));
        System.out.println("Older typed-array form: " + Arrays.toString(olderStyle));
        System.out.println("Set to String[]: " + Arrays.toString(fromSet));

        // toArray(String[]::new) works on Collection, so it works on List and Set.
        Collection<String> collection = courses;
        String[] fromCollection = collection.toArray(String[]::new);
        System.out.println("Collection to String[]: " + Arrays.toString(fromCollection));
    }
}