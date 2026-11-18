package com.example.example.exceptionhandling;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

/** INTERVIEW TRAP 55: whenComplete observes a failure but does not turn it into success. */
public class ExceptionHandling55WhenCompleteDoesNotRecover {
    public static void main(String[] args) {
        CompletableFuture<String> observed = CompletableFuture
                .<String>failedFuture(new IOException("Remote call failed"))
                .whenComplete((value, failure) -> {
                    System.out.println("whenComplete observed: " + failure);
                    // Logging or observing the failure does not recover this stage.
                });

        try {
            System.out.println(observed.join());
        } catch (CompletionException exception) {
            System.out.println("Stage still failed with: " + exception.getCause());
        }
    }
}
