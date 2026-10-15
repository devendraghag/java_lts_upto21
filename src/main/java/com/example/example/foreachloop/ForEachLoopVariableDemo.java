package com.example.foreachloop;

/** Demonstrates that the loop variable receives a value, while object references can mutate objects. */
public class ForEachLoopVariableDemo {
    private static final class Box {
        private int value;

        private Box(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        for (int number : numbers) {
            number = 99; // Changes only the loop variable, not the array element.
        }
        System.out.println("Primitive array remains: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]);

        Box[] boxes = {new Box(1), new Box(2)};
        for (Box box : boxes) {
            box.value *= 10; // The copied reference still points to the array's object.
        }
        System.out.println("Mutated object values: " + boxes[0].value + ", " + boxes[1].value);
    }
}
