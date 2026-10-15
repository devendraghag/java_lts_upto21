package com.example.comparable;

import java.util.List;

public class Comparable52InheritedGenericComparable {
    abstract static class Entity implements Comparable<Entity> {
        private final int id;

        Entity(int id) {
            this.id = id;
        }

        int id() {
            return id;
        }

        @Override
        public int compareTo(Entity other) {
            return Integer.compare(id, other.id);
        }
    }

    static final class Customer extends Entity {
        private final String name;

        Customer(int id, String name) {
            super(id);
            this.name = name;
        }

        @Override
        public String toString() {
            return "Customer[id=" + id() + ", name=" + name + "]";
        }
    }

    // Customer inherits Comparable<Entity>; <? super T> permits this compatible parent type.
    private static <T extends Comparable<? super T>> List<T> sortNaturally(List<T> values) {
        return values.stream().sorted().toList();
    }

    public static void main(String[] args) {
        System.out.println(sortNaturally(List.of(
                new Customer(30, "Cora"),
                new Customer(10, "Ari"),
                new Customer(20, "Bo"))));
    }
}
