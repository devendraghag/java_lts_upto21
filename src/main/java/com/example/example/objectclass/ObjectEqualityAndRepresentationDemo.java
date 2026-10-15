package com.example.objectclass;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** Overrides Object.toString(), equals(), and hashCode() consistently. */
public class ObjectEqualityAndRepresentationDemo {
    public static void main(String[] args) {
        UserKey first = new UserKey("user-21");
        UserKey second = new UserKey("user-21");

        System.out.println("Text: " + first); // Calls toString().
        System.out.println("Runtime class: " + first.getClass().getName());
        System.out.println("Same value: " + first.equals(second));
        System.out.println("Equal objects have same hash: " + (first.hashCode() == second.hashCode()));

        Set<UserKey> keys = new HashSet<>();
        keys.add(first);
        keys.add(second);
        System.out.println("Set size: " + keys.size()); // 1, because equals/hashCode agree.
    }

    private static final class UserKey {
        private final String id;

        UserKey(String id) { this.id = Objects.requireNonNull(id, "id"); }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;
            UserKey userKey = (UserKey) other;
            return id.equals(userKey.id);
        }

        @Override
        public int hashCode() { return Objects.hash(id); }

        @Override
        public String toString() { return "UserKey[id=" + id + "]"; }
    }
}
