package com.example.interfacestaticmethods;

/** Demonstrates independent static methods declared by parent and child interfaces. */
public class InterfaceStaticMethodInheritanceDemo {
    private interface ParentTools {
        static String label() {
            return "ParentTools static method";
        }
    }

    private interface ChildTools extends ParentTools {
        static String label() {
            return "ChildTools static method";
        }
    }

    public static void main(String[] args) {
        System.out.println(ParentTools.label());
        System.out.println(ChildTools.label());
    }
}
