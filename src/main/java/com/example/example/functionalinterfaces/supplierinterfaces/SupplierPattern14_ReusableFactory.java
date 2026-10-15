package com.example.functionalinterfaces.supplierinterfaces;

import java.util.function.Supplier;

/** Pattern 14: store or return a Supplier as a reusable factory. */
public class SupplierPattern14_ReusableFactory {
    private static Supplier<StringBuilder> builderFactory() {
        return StringBuilder::new;
    }

    public static void main(String[] args) {
        Supplier<StringBuilder> factory = builderFactory();
        StringBuilder first = factory.get().append("one");
        StringBuilder second = factory.get().append("two");
        System.out.println(first);
        System.out.println(second);
    }
}