package com.example.example.patternmatchingforswitch;

/** Level 13: cover an open non-sealed branch with its parent type pattern. */
public class PatternSwitch13NonSealedBranch {
    sealed interface Event permits Created, ExtensionEvent { }

    record Created(String id) implements Event { }

    // This branch is open: other classes can implement ExtensionEvent.
    non-sealed interface ExtensionEvent extends Event {
        String description();
    }

    static final class ImportedEvent implements ExtensionEvent {
        @Override
        public String description() {
            return "Imported from an external system";
        }
    }

    static String describe(Event event) {
        return switch (event) {
            case Created created -> "Created item " + created.id();
            // This case covers ExtensionEvent and any class implementing it.
            case ExtensionEvent extension -> extension.description();
        };
    }

    public static void main(String[] args) {
        System.out.println(describe(new Created("A-17")));
        System.out.println(describe(new ImportedEvent()));
    }
}
