package com.example.example.methodoverriding;

/** Rule 3: the runtime object's class selects an overridden instance method. */
public class Rule03RuntimeDispatch {
    static class Shape { void draw() { System.out.println("Shape"); } }
    static class Circle extends Shape { @Override void draw() { System.out.println("Circle"); } }
    public static void main(String[] args) {
        Shape value = new Circle();
        value.draw();
    }
}
