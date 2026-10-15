package com.example.example.methodoverriding;

/** Rule 21: equal objects should produce the same hash code. */
public class Rule21OverrideHashCode {
    static class Key {
        private final int value;
        Key(int value) { this.value = value; }
        @Override public boolean equals(Object other) { return other instanceof Key && value == ((Key) other).value; }
        @Override public int hashCode() { return value; }
    }
    public static void main(String[] args) { System.out.println(new Key(8).hashCode()); }
}
