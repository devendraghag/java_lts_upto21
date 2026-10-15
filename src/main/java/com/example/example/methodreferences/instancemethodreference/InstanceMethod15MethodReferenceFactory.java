package com.example.methodreferences.instancemethodreference;

import java.util.function.Function;

/** Hard: a method can return a bound reference that keeps its receiver object. */
public class InstanceMethod15MethodReferenceFactory {
    static class Prefixer {
        private final String prefix;

        Prefixer(String prefix) {
            this.prefix = prefix;
        }

        String apply(String value) {
            return prefix + value;
        }

        Function<String, String> asFunction() {
            // Equivalent: value -> this.apply(value)
            return this::apply;
        }
    }

    public static void main(String[] args) {
        Function<String, String> addWarning = new Prefixer("Warning: ").asFunction();
        Function<String, String> addInfo = new Prefixer("Info: ").asFunction();

        System.out.println(addWarning.apply("check input"));
        System.out.println(addInfo.apply("loaded"));
    }
}
