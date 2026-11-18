package com.example.example.exceptionhandling;

import java.io.FileNotFoundException;
import java.io.IOException;

/** HARD 24: an override may narrow a checked exception, omit it, or throw unchecked exceptions. */
public class ExceptionHandling24OverrideThrowsRules {
    static class ParentService {
        void load() throws IOException {
            System.out.println("Parent load");
        }
    }

    static class NarrowingService extends ParentService {
        @Override
        void load() throws FileNotFoundException {
            System.out.println("Override narrows IOException to FileNotFoundException");
        }
    }

    static class NoCheckedExceptionService extends ParentService {
        @Override
        void load() {
            System.out.println("Override declares no checked exception");
        }
    }

    static class UncheckedFailureService extends ParentService {
        @Override
        void load() throws IllegalStateException {
            throw new IllegalStateException("Unchecked exceptions are allowed");
        }
    }

    // This would not compile: an override cannot add a broader/new checked exception.
    // static class InvalidService extends ParentService {
    //     @Override void load() throws Exception { }
    // }

    private static void callUsingParentType(ParentService service) {
        try {
            service.load();
        } catch (IOException exception) {
            // The caller follows the throws clause visible on ParentService.
            System.out.println("Handled declared checked exception: " + exception);
        }
    }

    public static void main(String[] args) {
        callUsingParentType(new NarrowingService());
        callUsingParentType(new NoCheckedExceptionService());
        try {
            callUsingParentType(new UncheckedFailureService());
        } catch (IllegalStateException exception) {
            System.out.println("Handled unchecked exception: " + exception.getMessage());
        }
    }
}
