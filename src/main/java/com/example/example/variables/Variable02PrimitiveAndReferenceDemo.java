package com.example.variables;

/** Level 02: Demonstrates primitive variables and reference variables. */
public class Variable02PrimitiveAndReferenceDemo {
    private static final class Counter {
        private int value;

        private Counter(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int originalNumber = 7;
        int copiedNumber = originalNumber;
        copiedNumber++;
        System.out.println("Primitive original=" + originalNumber + ", copy=" + copiedNumber);

        Counter firstReference = new Counter(10);
        Counter secondReference = firstReference; // Copies the reference value.
        secondReference.value++;
        System.out.println("Shared object value=" + firstReference.value);
        System.out.println("References point to same object=" + (firstReference == secondReference));
    }
}
