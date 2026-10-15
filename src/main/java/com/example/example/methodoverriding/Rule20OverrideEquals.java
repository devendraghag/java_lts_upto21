package com.example.example.methodoverriding;

/** Rule 20: equals(Object) must keep its exact signature to override Object.equals. */
public class Rule20OverrideEquals {
    static class User {
        private final int id;
        User(int id) { this.id = id; }
        @Override public boolean equals(Object other) {
            return other instanceof User && id == ((User) other).id;
        }
    }
    public static void main(String[] args) { System.out.println(new User(5).equals(new User(5))); }
}
