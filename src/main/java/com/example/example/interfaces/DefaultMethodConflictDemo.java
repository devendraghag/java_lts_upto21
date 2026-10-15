package com.example.interfaces;

/** Demonstrates resolving conflicting defaults from unrelated interfaces. */
public class DefaultMethodConflictDemo {
    private interface FirstAction {
        default void perform() {
            System.out.println("First action");
        }
    }

    private interface SecondAction {
        default void perform() {
            System.out.println("Second action");
        }
    }

    private static final class CombinedAction implements FirstAction, SecondAction {
        @Override
        public void perform() {
            FirstAction.super.perform();
            SecondAction.super.perform();
            System.out.println("Combined action");
        }
    }

    public static void main(String[] args) {
        new CombinedAction().perform();
    }
}
