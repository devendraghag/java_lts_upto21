package com.example.streamarrayandreduction;

import java.util.Arrays;
import java.util.List;

/** Demonstrates both Stream.toArray overloads. */
public class ToArrayFormsDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Asha", "Ravi", "Mina");

        // The no-argument overload returns Object[].
        Object[] objects = names.stream().toArray();
        System.out.println("No-argument overload: " + Arrays.toString(objects));
        System.out.println("Array type: " + objects.getClass().getTypeName());

        // The generator overload creates an array with the requested component type.
        String[] strings = names.stream().toArray(String[]::new);
        System.out.println("Generator overload: " + Arrays.toString(strings));
        System.out.println("Array type: " + strings.getClass().getTypeName());
    }
}
