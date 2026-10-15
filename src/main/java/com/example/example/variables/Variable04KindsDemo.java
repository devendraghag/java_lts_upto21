package com.example.variables;

/** Level 04: Local variables, parameters, instance fields, and class (static) fields. */
public class Variable04KindsDemo {
    private static int objectCount; // One class variable shared by every instance.
    private final int objectNumber; // A separate instance variable for each object.

    private Variable04KindsDemo() {
        objectNumber = ++objectCount;
    }

    public static void main(String[] args) {
        int localValue = 10; // Local variable, declared inside a method.
        String referenceVariable = "Hello"; // A reference variable stores an object reference.
        Variable04KindsDemo first = new Variable04KindsDemo();
        Variable04KindsDemo second = new Variable04KindsDemo();

        System.out.println("Local primitive: " + localValue);
        System.out.println("Local reference: " + referenceVariable);
        first.printValues(100); // 100 is passed into a parameter variable.
        second.printValues(200);
        System.out.println("Shared static count: " + Variable04KindsDemo.objectCount);
    }

    private void printValues(int parameter) {
        int methodLocal = parameter + objectNumber;
        System.out.println("Parameter + this object's field: " + methodLocal);
    }
}
