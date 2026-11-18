package com.example.example.recordpatterns;

/** Level 11: record-pattern deconstruction reads components through their accessors. */
public class RecordPattern11AccessorInvocation {
    record Reading(int value) {
        private static int accessorCalls;

        @Override
        public int value() {
            accessorCalls++;
            return value;
        }
    }

    public static void main(String[] args) {
        Object sample = new Reading(42);

        if (sample instanceof Reading(int value)) {
            System.out.println("Extracted component: " + value);
        }

        System.out.println("Component accessor calls: " + Reading.accessorCalls);
    }
}
