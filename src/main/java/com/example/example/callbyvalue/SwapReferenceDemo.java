package com.example.callbyvalue;

/** Demonstrates why assigning parameter references cannot swap caller variables. */
public class SwapReferenceDemo {
    private static final class Item {
        private final String name;

        private Item(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private static void swap(Item first, Item second) {
        Item temporary = first;
        first = second;
        second = temporary;
        System.out.println("Inside method: first=" + first + ", second=" + second);
    }

    public static void main(String[] args) {
        Item left = new Item("left object");
        Item right = new Item("right object");

        swap(left, right);
        System.out.println("After method: left=" + left + ", right=" + right);
    }
}
