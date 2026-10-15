package com.example.instanceinitializationblock;

/** Shows field initializers and multiple IIBs in textual order before the constructor body. */
public class BasicIibOrderDemo {
    private String first = mark("field initializer 1");

    {
        mark("instance initializer block 1");
    }

    private String second = mark("field initializer 2");

    {
        mark("instance initializer block 2");
    }

    public BasicIibOrderDemo() {
        mark("constructor body");
        System.out.println("Initialized values: " + first + ", " + second);
    }

    public static void main(String[] args) {
        System.out.println("Creating the first object:");
        new BasicIibOrderDemo();
        System.out.println("Creating another object:");
        new BasicIibOrderDemo();
    }

    private String mark(String step) {
        System.out.println(step);
        return step;
    }
}
