package com.example.methodreferences.instancemethodreference;

import java.util.function.Function;

/** Challenge: two bound references can call the same method with different captured state. */
public class InstanceMethod16SpecificReceiverComparison {
    static class Multiplier {
        private final int factor;

        Multiplier(int factor) {
            this.factor = factor;
        }

        int apply(int value) {
            return value * factor;
        }
    }

    public static void main(String[] args) {
        Multiplier timesTwo = new Multiplier(2);
        Multiplier timesFive = new Multiplier(5);
        Function<Integer, Integer> doubleValue = timesTwo::apply;
        Function<Integer, Integer> timesFiveValue = timesFive::apply;

        System.out.println("2 * 7 = " + doubleValue.apply(7));
        System.out.println("5 * 7 = " + timesFiveValue.apply(7));
    }
}
