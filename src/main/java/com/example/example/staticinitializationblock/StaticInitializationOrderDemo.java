package com.example.staticinitializationblock;

/** Demonstrates that static field initializers and static blocks run in textual order. */
public class StaticInitializationOrderDemo {
    private static int value = mark("field initializer 1", 10);

    static {
        value += 5;
        System.out.println("static block 1; value=" + value);
    }

    private static int otherValue = mark("field initializer 2", 20);

    static {
        value += otherValue;
        System.out.println("static block 2; value=" + value);
    }

    private static int mark(String source, int number) {
        System.out.println(source);
        return number;
    }

    public static void main(String[] args) {
        System.out.println("Final value=" + value);
    }
}
