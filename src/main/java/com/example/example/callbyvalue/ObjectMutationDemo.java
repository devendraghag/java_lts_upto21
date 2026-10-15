package com.example.callbyvalue;

/** Demonstrates that a copied object reference can mutate the shared object. */
public class ObjectMutationDemo {
    private static final class Box {
        private int value;

        private Box(int value) {
            this.value = value;
        }
    }

    private static void changeObject(Box box) {
        box.value = 42;
    }

    public static void main(String[] args) {
        Box original = new Box(10);
        changeObject(original);
        System.out.println("Value after method: " + original.value);
    }
}
