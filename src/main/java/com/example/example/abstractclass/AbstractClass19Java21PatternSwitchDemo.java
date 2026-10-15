package com.example.abstractclass;

/** Java 21: exhaustive pattern matching in switch over a sealed abstract hierarchy. */
public class AbstractClass19Java21PatternSwitchDemo {
    public static void main(String[] args) {
        Outcome[] outcomes = {new Success("Saved"), new Failure("Disk full")};
        for (Outcome outcome : outcomes) {
            System.out.println(describe(outcome));
        }
    }

    private static String describe(Outcome outcome) {
        return switch (outcome) {
            case Success success -> "Success: " + success.message();
            case Failure failure -> "Failure: " + failure.reason();
        };
    }

    private abstract static sealed class Outcome permits Success, Failure { }

    private static final class Success extends Outcome {
        private final String message;
        private Success(String message) { this.message = message; }
        private String message() { return message; }
    }

    private static final class Failure extends Outcome {
        private final String reason;
        private Failure(String reason) { this.reason = reason; }
        private String reason() { return reason; }
    }
}
