package com.example.callbyvalue;

/** Demonstrates that reassigning a copied reference does not change the caller's variable. */
public class ReferenceReassignmentDemo {
    private static final class Box {
        private final String label;

        private Box(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return "Box(" + label + ")";
        }
    }

    private static void replace(Box parameter) {
        parameter = new Box("created inside method");
        System.out.println("Inside method: " + parameter);
    }

    public static void main(String[] args) {
        Box original = new Box("caller object");
        replace(original);
        System.out.println("After method: " + original);
    }
}
