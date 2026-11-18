package com.example.example.patternmatchinginstanceof;

/** Level 14: instanceof matches a value assignable to the tested type, including subclasses. */
public class PatternMatchingInstanceof14SubtypeMatch {
    static class Account {
        String owner() {
            return "Account owner";
        }
    }

    static final class PremiumAccount extends Account {
        String benefits() {
            return "Premium benefits";
        }
    }

    static void inspect(Object value) {
        if (value instanceof Account account) {
            System.out.println(account.owner());
            System.out.println("Runtime type: " + value.getClass().getSimpleName());
        }

        // instanceof tests whether the object can be used as Account,
        // not whether its exact runtime class is Account.class.
        System.out.println("Exact Account class: " + (value.getClass() == Account.class));
    }

    public static void main(String[] args) {
        inspect(new PremiumAccount());
    }
}
