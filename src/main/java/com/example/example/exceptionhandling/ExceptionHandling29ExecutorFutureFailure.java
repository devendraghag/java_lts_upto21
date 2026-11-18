package com.example.example.exceptionhandling;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** HARD 29: ExecutorService captures a task exception and exposes it through Future.get(). */
public class ExceptionHandling29ExecutorFutureFailure {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<Integer> result = executor.submit(() -> {
                throw new IllegalArgumentException("Task input was invalid");
            });

            try {
                result.get();
            } catch (ExecutionException exception) {
                // Future.get wraps the task's failure; inspect the original cause.
                System.out.println("Task cause: " + exception.getCause());
            }
        } finally {
            executor.shutdown();
        }
    }
}
