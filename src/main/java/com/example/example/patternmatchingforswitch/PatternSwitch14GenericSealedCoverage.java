package com.example.example.patternmatchingforswitch;

/** Level 14: show exhaustiveness analysis for a generic sealed interface. */
public class PatternSwitch14GenericSealedCoverage {
    sealed interface Token<T> permits TextToken, GenericToken { }

    // This permitted type can only be a Token<String>.
    static final class TextToken<X> implements Token<String> { }

    // This permitted type can represent Token<T> for any T.
    static final class GenericToken<T> implements Token<T> {
        private final T value;

        GenericToken(T value) {
            this.value = value;
        }

        T value() {
            return value;
        }
    }

    static String describe(Token<Integer> token) {
        return switch (token) {
            // TextToken cannot be a Token<Integer>, so this one case is exhaustive.
            case GenericToken<Integer> integerToken -> "Integer token: " + integerToken.value();
        };
    }

    public static void main(String[] args) {
        Token<Integer> token = new GenericToken<>(42);
        System.out.println(describe(token));
    }
}
