package com.example.methodreferences.instancemethodreference;

import java.util.function.BiFunction;

/** Medium: two functional inputs are arguments to a method on the captured calculator. */
public class InstanceMethod05BiFunction {
    static class Calculator {
        int multiply(int left, int right) {
            return left * right;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        BiFunction<Integer, Integer, Integer> lambda = (left, right) -> calculator.multiply(left, right);
        BiFunction<Integer, Integer, Integer> reference = calculator::multiply;

        System.out.println(lambda.apply(4, 5));
        System.out.println(reference.apply(6, 7));
    }
}
