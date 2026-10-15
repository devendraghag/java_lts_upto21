package com.example.methodreferences.staticmethodreference;

import java.util.function.Function;

/** Easy: ClassName::staticMethod matches Function<Integer, Integer>. */
public class StaticMethod01MathAbs {
    public static void main(String[] args) {
        Function<Integer, Integer> lambda = number -> Math.abs(number);
        Function<Integer, Integer> reference = Math::abs;

        System.out.println(lambda.apply(-12));
        System.out.println(reference.apply(-35));
    }
}
