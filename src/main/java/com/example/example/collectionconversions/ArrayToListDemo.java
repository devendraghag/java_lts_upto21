package com.example.collectionconversions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Array to List conversions with different mutability and backing behavior. */
public class ArrayToListDemo {
    public static void main(String[] args) {
        String[] courseArray = {"Java", "Spring", "SQL"};

        List<String> fixedSizeView = Arrays.asList(courseArray);
        fixedSizeView.set(0, "Java SE"); // Allowed; the array and list view both change.
        System.out.println("Arrays.asList view: " + fixedSizeView);
        System.out.println("Changed source array: " + Arrays.toString(courseArray));

        List<String> mutableCopy = new ArrayList<>(Arrays.asList(courseArray));
        mutableCopy.add("Docker");
        System.out.println("Mutable ArrayList copy: " + mutableCopy);

        List<String> immutableCopy = List.copyOf(Arrays.asList(courseArray));
        System.out.println("Immutable copy: " + immutableCopy);
    }
}