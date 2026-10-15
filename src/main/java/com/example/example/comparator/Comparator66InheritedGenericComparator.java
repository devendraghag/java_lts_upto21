package com.example.comparator;

import java.util.Comparator;
import java.util.List;

public class Comparator66InheritedGenericComparator {
    abstract static class Entity {
        private final int id;

        Entity(int id) {
            this.id = id;
        }

        int id() {
            return id;
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

    // A comparator for the parent type can sort a list of its child type.
    private static <T> List<T> sortBy(List<T> values, Comparator<? super T> order) {
        return values.stream().sorted(order).toList();
    }

    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer(30, "Cora"),
                new Customer(10, "Ari"),
                new Customer(20, "Bo"));
        Comparator<Entity> byId = Comparator.comparingInt(Entity::id);
        System.out.println(sortBy(customers, byId));
    }
}
