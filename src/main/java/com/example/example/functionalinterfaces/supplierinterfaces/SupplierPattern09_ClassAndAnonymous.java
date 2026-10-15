package com.example.functionalinterfaces.supplierinterfaces;

import java.util.function.Supplier;

/** Pattern 9: implement Supplier with a class or an anonymous class. */
public class SupplierPattern09_ClassAndAnonymous {
    private static final class GreetingSupplier implements Supplier<String> {
        @Override
        public String get() {
            return "Hello from a named Supplier";
        }
    }

    public static void main(String[] args) {
        Supplier<String> named = new GreetingSupplier();
        Supplier<String> anonymous = new Supplier<>() {
            @Override
            public String get() {
                return "Hello from an anonymous Supplier";
            }
        };
        System.out.println(named.get());
        System.out.println(anonymous.get());
    }
}