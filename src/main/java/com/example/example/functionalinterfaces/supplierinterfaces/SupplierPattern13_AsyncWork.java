package com.example.functionalinterfaces.supplierinterfaces;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/** Pattern 13: CompletableFuture.supplyAsync accepts a Supplier for work that returns a value. */
public class SupplierPattern13_AsyncWork {
    public static void main(String[] args) {
        Supplier<String> loadMessage = () -> "Loaded on " + Thread.currentThread().getName();
        String result = CompletableFuture.supplyAsync(loadMessage).join();
        System.out.println(result);
    }
}