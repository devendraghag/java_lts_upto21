package com.example.functionalinterfaces.supplierinterfaces;

import java.util.Optional;
import java.util.function.Supplier;

/** Pattern 11: provide an Optional fallback lazily with orElseGet. */
public class SupplierPattern11_LazyOptionalFallback {
    public static void main(String[] args) {
        Optional<String> present = Optional.of("saved value");
        Optional<String> missing = Optional.empty();
        Supplier<String> fallback = () -> {
            System.out.println("Creating fallback");
            return "default value";
        };

        System.out.println(present.orElseGet(fallback));
        System.out.println(missing.orElseGet(fallback));
    }
}