package com.example.objectclass;

/** Demonstrates runtime class information, default identity behavior, and arrays as Objects. */
public class ObjectGetClassAndIdentityDemo {
    public static void main(String[] args) {
        Object value = new StringBuilder("Hello");
        System.out.println("Runtime class: " + value.getClass().getName());
        System.out.println("Runtime package: " + value.getClass().getPackageName());
        System.out.println("Object string form: " + value);
        System.out.println("Identity hash (not a unique ID): " + System.identityHashCode(value));

        int[] numbers = {1, 2, 3};
        System.out.println("Array runtime class: " + numbers.getClass().getName());
        System.out.println("Array is an Object: " + (numbers instanceof Object));
    }
}
