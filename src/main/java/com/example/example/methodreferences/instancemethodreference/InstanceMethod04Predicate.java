package com.example.methodreferences.instancemethodreference;

import java.util.function.Predicate;

/** Easy+: Predicate input is passed to a method on the captured validator object. */
public class InstanceMethod04Predicate {
    static class NameValidator {
        boolean isAcceptable(String name) {
            return name != null && name.length() >= 4;
        }
    }

    public static void main(String[] args) {
        NameValidator validator = new NameValidator();
        Predicate<String> lambda = name -> validator.isAcceptable(name);
        Predicate<String> reference = validator::isAcceptable;

        System.out.println(lambda.test("Ava"));
        System.out.println(reference.test("Mina"));
    }
}
