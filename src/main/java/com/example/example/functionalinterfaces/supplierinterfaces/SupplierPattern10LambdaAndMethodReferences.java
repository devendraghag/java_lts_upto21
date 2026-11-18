package com.example.example.functionalinterfaces.supplierinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/** Pattern 10: use lambdas and constructor or static method references. */
public class SupplierPattern10LambdaAndMethodReferences {
    public static void main(String[] args) {
        Supplier<String> constant = () -> "Java";
        Supplier<StringBuilder> builderFactory = StringBuilder::new;
        Supplier<Long> clock = System::nanoTime;

        System.out.println(constant.get());
        System.out.println("New builder length: " + builderFactory.get().length());
        System.out.println("Clock reading: " + clock.get());
    }
}