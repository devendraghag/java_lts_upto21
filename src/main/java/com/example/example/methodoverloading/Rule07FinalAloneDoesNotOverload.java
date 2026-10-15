package com.example.example.methodoverloading;

/** Rule 7: changing only the final modifier does not create an overload. */
public class Rule07FinalAloneDoesNotOverload {
    void calculate(int value) {
        System.out.println(value * 2);
    }

    // This would not compile beside calculate(int):
    // final void calculate(int value) { System.out.println(value * 3); }
    // The final modifier is not part of the method signature.

    public static void main(String[] args) {
        new Rule07FinalAloneDoesNotOverload().calculate(5);
    }
}
