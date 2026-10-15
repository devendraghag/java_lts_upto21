package com.example.operators;

/**
 * Demonstrates Java operator categories and common usage through JDK 21.
 * Includes finalized pattern matching for switch (JDK 21); no preview or
 * incubator features are used.
 *
 * Compile and run from the source root with JDK 21:
 *   javac -d out com/example/operators/JavaOperatorsExamples.java
 *   java -cp out com.example.operators.JavaOperatorsExamples
 */
public class JavaOperatorsExamples {
    public static void main(String[] args) {
        arithmeticOperators();
        unaryAndAssignmentOperators();
        comparisonAndLogicalOperators();
        bitwiseAndShiftOperators();
        conditionalAndTypeOperators();
        patternMatchingInJdk21();
        precedenceAndAssociativity();
    }

    private static void arithmeticOperators() {
        System.out.println("== Arithmetic operators ==");

        int a = 17;
        int b = 5;
        System.out.println("+ - * / %: " + (a + b) + ", " + (a - b) + ", "
                + (a * b) + ", " + (a / b) + ", " + (a % b));
        System.out.println("integer division truncates: 17 / 5 = " + (a / b));
        System.out.println("floating-point division: 17.0 / 5 = " + (17.0 / b));

        String combined = "Java " + 21; // + also concatenates when either operand is a String
        System.out.println("String concatenation with +: " + combined);
    }

    private static void unaryAndAssignmentOperators() {
        System.out.println("\n== Unary and assignment operators ==");

        int value = 4;
        System.out.println("prefix ++ returns updated value: " + (++value));
        System.out.println("postfix ++ returns old value: " + (value++));
        System.out.println("value afterward: " + value);
        System.out.println("unary + / - / ! / ~: " + (+value) + " / " + (-value)
                + " / " + (!true) + " / " + (~value));

        int total = 10;
        total += 3;
        total *= 2;
        total -= 4;
        total /= 2;
        total %= 5;
        System.out.println("compound assignments += *= -= /= %=: " + total);

        int bits = 12; // 1100 in binary
        bits &= 10;    // 1010 -> 1000
        System.out.println("compound bitwise assignment &= : " + bits);
    }

    private static void comparisonAndLogicalOperators() {
        System.out.println("\n== Comparison, equality, and logical operators ==");

        int x = 7;
        int y = 9;
        System.out.println("< <= > >= == !=: " + (x < y) + " " + (x <= y) + " "
                + (x > y) + " " + (x >= y) + " " + (x == y) + " " + (x != y));

        boolean allowed = x > 0 && y > x; // && short-circuits
        boolean eitherCondition = x < 0 || y == 9; // || short-circuits
        boolean inverted = !allowed;
        System.out.println("&& / || / !: " + allowed + " / " + eitherCondition + " / " + inverted);

        int counter = 0;
        boolean shortCircuited = false && incrementAndCheck(counter);
        boolean alsoShortCircuited = true || incrementAndCheck(counter);
        System.out.println("short circuit skips right operand: "
                + shortCircuited + " / " + alsoShortCircuited);
        System.out.println("counter remains: " + counter);

        boolean eagerAnd = false & incrementAndCheck(counter);
        boolean eagerOr = true | incrementAndCheck(counter);
        System.out.println("boolean & / | evaluate both operands: " + eagerAnd + " / " + eagerOr);
        System.out.println("counter after eager evaluation: " + counter);

        String first = new String("same");
        String second = new String("same");
        System.out.println("String == compares references; equals compares content: "
                + (first == second) + " / " + first.equals(second));
    }

    private static boolean incrementAndCheck(int value) {
        // The argument is passed by value; this method makes its execution visible in output.
        System.out.println("right operand evaluated (received " + value + ")");
        return true;
    }

    private static void bitwiseAndShiftOperators() {
        System.out.println("\n== Bitwise and shift operators ==");

        int left = 12; // 1100
        int right = 10; // 1010
        System.out.println("& | ^: " + (left & right) + " / " + (left | right) + " / " + (left ^ right));
        System.out.println("~left: " + (~left));
        System.out.println("<< >> >>>: " + (left << 2) + " / " + (left >> 2)
                + " / " + (-8 >>> 1));

        boolean p = true;
        boolean q = false;
        System.out.println("boolean bitwise & | ^ (no short circuit): "
                + (p & q) + " / " + (p | q) + " / " + (p ^ q));
    }

    private static void conditionalAndTypeOperators() {
        System.out.println("\n== Conditional, cast, and instanceof operators ==");

        int age = 20;
        String status = age >= 18 ? "adult" : "minor"; // conditional / ternary operator
        System.out.println("condition ? value1 : value2: " + status);

        double price = 19.99;
        int wholePrice = (int) price; // cast; fractional part is discarded
        System.out.println("cast double to int: " + wholePrice);

        Object value = "Java";
        if (value instanceof String text) { // pattern matching for instanceof, final since JDK 16
            System.out.println("instanceof pattern variable: " + text.toUpperCase());
        }
    }

    private static void patternMatchingInJdk21() {
        System.out.println("\n== Pattern matching for switch (JDK 21) ==");

        Shape circle = new Circle(3);
        Shape rectangle = new Rectangle(4, 5);
        System.out.println("circle area: " + area(circle));
        System.out.println("rectangle area: " + area(rectangle));
    }

    private static double area(Shape shape) {
        // Switch patterns became a permanent feature in JDK 21.
        return switch (shape) {
            case Circle circle -> Math.PI * circle.radius() * circle.radius();
            case Rectangle rectangle -> rectangle.width() * rectangle.height();
        };
    }

    private static void precedenceAndAssociativity() {
        System.out.println("\n== Precedence and parentheses ==");

        int resultWithoutParentheses = 2 + 3 * 4;
        int resultWithParentheses = (2 + 3) * 4;
        System.out.println("2 + 3 * 4 = " + resultWithoutParentheses);
        System.out.println("(2 + 3) * 4 = " + resultWithParentheses);

        int chained = 20 / 5 * 2; // same precedence, evaluated left to right
        System.out.println("20 / 5 * 2 = " + chained);
        System.out.println("Use parentheses to make intended grouping clear.");
    }

    private sealed interface Shape permits Circle, Rectangle { }

    private record Circle(double radius) implements Shape { }

    private record Rectangle(double width, double height) implements Shape { }
}
