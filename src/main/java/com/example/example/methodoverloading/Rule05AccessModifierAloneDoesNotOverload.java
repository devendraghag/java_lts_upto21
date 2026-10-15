package com.example.example.methodoverloading;

/** Rule 5: changing only access level does not create an overload. */
public class Rule05AccessModifierAloneDoesNotOverload {
    public void print(String value) {
        System.out.println(value);
    }

    // This would not compile beside print(String):
    // private void print(String value) { System.out.println(value); }
    // Access modifiers do not distinguish a method signature.

    public static void main(String[] args) {
        new Rule05AccessModifierAloneDoesNotOverload().print("public method");
    }
}
