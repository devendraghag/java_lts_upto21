package com.example.methodreferences.instancemethodreference;

import java.util.function.Function;

/** Medium: this::method captures the current object as the method-reference receiver. */
public class InstanceMethod08ThisReference {
    private final String prefix;

    InstanceMethod08ThisReference(String prefix) {
        this.prefix = prefix;
    }

    private String addPrefix(String value) {
        return prefix + value;
    }

    private void demonstrate() {
        Function<String, String> lambda = value -> this.addPrefix(value);
        Function<String, String> reference = this::addPrefix;
        System.out.println(lambda.apply("Streams"));
        System.out.println(reference.apply("Method references"));
    }

    public static void main(String[] args) {
        new InstanceMethod08ThisReference("Learning: ").demonstrate();
    }
}
