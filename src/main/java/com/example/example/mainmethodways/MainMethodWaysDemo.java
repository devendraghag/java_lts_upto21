package com.example.mainmethodways;

/**
 * Demonstrates valid Java application main methods and common invalid forms.
 * Uses Java SE features available by JDK 21; no preview or incubator APIs.
 *
 * Compile and run from the source root:
 *   javac -d out com/example/mainmethodways/MainMethodWaysDemo.java
 *   java -cp out com.example.mainmethodways.MainMethodWaysDemo
 *
 * Main-method declarations shown here are valid for the JDK 21 launcher.
 */
public class MainMethodWaysDemo {
    public static void main(String[] args) {
        System.out.println("== Valid main method forms ==");
        System.out.println("Standard: public static void main(String[] args)");

        ModifierOrderExample.main(args);
        ArrayNotationExample.main(args);
        VarargsExample.main(args);
        FinalModifierExample.main(args);
        FinalFirstExample.main(args);
        ModifierOrderWithStrictfpExample.main(args);
        OptionalSemicolonExample.main(args);

        System.out.println("\nEach example above is in a separate class because methods with "
                + "String[] and String... have the same signature.");
        System.out.println("An extra semicolon after a class declaration is an optional empty declaration.");

        System.out.println("\n== Invalid or non-launchable forms ==");
        System.out.println("See comments below: some are legal Java methods but are not JDK 21 launcher entry points;");
        System.out.println("others are compile-time errors.");
    }

    /** Modifier order can change without changing the method signature. */
    public static class ModifierOrderExample {
        static public void main(String[] args) {
            System.out.println("static public void main(String[] args)");
        }
    }

    /** Whitespace around the array brackets does not change the parameter type. */
    public static class ArrayNotationExample {
        public static void main(String []args) {
            System.out.println("public static void main(String []args)");
        }
    }

    /** Varargs is represented as a String[] parameter and is accepted by the launcher. */
    public static class VarargsExample {
        public static void main(String... args) {
            System.out.println("public static void main(String... args)");
        }
    }

    public static class FinalModifierExample {
        public static final void main(String[] args) {
            System.out.println("public static final void main(String[] args)");
        }
    }

    public static class FinalFirstExample {
        final public static void main(String[] args) {
            System.out.println("final public static void main(String[] args)");
        }
    }

    /** strictfp is still legal, though redundant for floating-point expressions since JDK 17. */
    public static class ModifierOrderWithStrictfpExample {
        final strictfp public static void main(String[] args) {
            System.out.println("final strictfp public static void main(String[] args)");
        }
    }

    // This class declaration may end with a semicolon. The semicolon is an empty declaration.
    static class OptionalSemicolonExample {
        static public void main(String... args) {
            System.out.println("OptionalSemicolonExample main");
        }
    };

    /*
     * Legal Java declarations, but not valid JDK 21 launcher entry points:
     *
     * public void main(String[] args) { } // instance method: launcher requires static
     * static void main(String[] args) { }  // not public: launcher requires public
     *
     * Compile-time errors:
     *
     * public void static main(String[] args) { }
     * // 'static' is in the wrong position; modifiers must precede the return type.
     *
     * abstract public static void main(String[] args);
     * // abstract and static cannot be combined, and an abstract method has no body.
     *
     * Other common notes:
     * - The method name and return type are case- and type-sensitive: main and void.
     * - String[] and String... are the same parameter signature; do not declare both
     *   in the same class.
     * - A no-argument main() or main(int args) may be an ordinary overload, but it is
     *   not the JDK 21 launcher entry point.
     * - Instance main methods from preview work in progress are intentionally excluded.
     */
}
