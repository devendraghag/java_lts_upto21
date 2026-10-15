package org.example.lts_features.level03_advanced.jdk17.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

/** Level 6: sealed interfaces can model a fixed set of generic outcomes. */
public class SealedClasses06GenericResult {
    sealed interface Result<T> permits Success, Failure { }

    record Success<T>(T value) implements Result<T> { }
    record Failure<T>(String message) implements Result<T> { }

    static String describe(Result<?> result) {
        if (result instanceof Success<?> success) {
            return "Success: " + success.value();
        } else if (result instanceof Failure<?> failure) {
            return "Failure: " + failure.message();
        }
        throw new IllegalStateException("Unexpected result type");
    }

    public static void main(String[] args) {
        Result<Integer> success = new Success<>(200);
        Result<Integer> failure = new Failure<>("Not found");

        System.out.println(describe(success));
        System.out.println(describe(failure));
    }
}