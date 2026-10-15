package com.example.methodreferences.staticmethodreference;

import java.util.function.Function;

/** Easy+: target types select String.valueOf(Object) for these Integer inputs. */
public class StaticMethod03StringValueOf {
    public static void main(String[] args) {
        Function<Integer, String> lambda = value -> String.valueOf(value);
        Function<Integer, String> reference = String::valueOf;

        System.out.println(lambda.apply(42));
        System.out.println(reference.apply(2021));
    }
}
