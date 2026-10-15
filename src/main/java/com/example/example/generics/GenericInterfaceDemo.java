package com.example.generics;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/** Demonstrates a generic interface and a type-safe implementation. */
public class GenericInterfaceDemo {
    private interface Repository<T, ID> {
        void save(ID id, T value);

        Optional<T> findById(ID id);
    }

    private static final class InMemoryRepository<T, ID> implements Repository<T, ID> {
        private final Map<ID, T> values = new HashMap<>();

        @Override
        public void save(ID id, T value) {
            values.put(id, value);
        }

        @Override
        public Optional<T> findById(ID id) {
            return Optional.ofNullable(values.get(id));
        }
    }

    public static void main(String[] args) {
        Repository<String, Integer> repository = new InMemoryRepository<>();
        repository.save(1, "Java Generics");
        System.out.println(repository.findById(1).orElse("not found"));
    }
}
