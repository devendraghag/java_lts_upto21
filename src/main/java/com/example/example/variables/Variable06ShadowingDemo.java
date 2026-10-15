package com.example.variables;

/** Level 06: Demonstrates field shadowing and explicit access with this and the class name. */
public class Variable06ShadowingDemo {
    private static String category = "class field";
    private String name = "instance field";

    private void show(String name) { // Parameter shadows the instance field.
        String category = "local variable"; // Local variable shadows the static field.
        System.out.println("Parameter name=" + name);
        System.out.println("Instance field name=" + this.name);
        System.out.println("Local category=" + category);
        System.out.println("Static field category=" + Variable06ShadowingDemo.category);
    }

    public static void main(String[] args) {
        new Variable06ShadowingDemo().show("method parameter");
    }
}
