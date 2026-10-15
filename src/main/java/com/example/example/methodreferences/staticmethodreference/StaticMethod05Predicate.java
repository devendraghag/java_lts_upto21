package com.example.methodreferences.staticmethodreference;

import java.util.function.Predicate;

/** Easy+: static boolean methods match Predicate<T> when they accept one T. */
public class StaticMethod05Predicate {
    static class NumberRules {
        static boolean isPositive(Integer number) {
            return number > 0;
        }
    }

    public static void main(String[] args) {
        Predicate<Integer> lambda = number -> NumberRules.isPositive(number);
        Predicate<Integer> reference = NumberRules::isPositive;

        System.out.println(lambda.test(-3));
        System.out.println(reference.test(8));
    }
}
