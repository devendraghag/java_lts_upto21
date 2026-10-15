package com.example.finalkeyword;

import java.lang.reflect.Modifier;

/** Final classes cannot be subclassed; records are implicitly final. */
public class FinalClassDemo {
    public static void main(String[] args) {
        SecurityToken token = new SecurityToken("token-21");
        System.out.println(token);
        System.out.println("Record is final: "
                + Modifier.isFinal(ImmutablePoint.class.getModifiers()));
    }

    private static final class SecurityToken {
        private final String value;
        SecurityToken(String value) { this.value = value; }
        @Override public String toString() { return "SecurityToken[" + value + "]"; }
    }

    // private static class SpecialToken extends SecurityToken {} // Cannot extend a final class.

    private record ImmutablePoint(int x, int y) {
    }
}
