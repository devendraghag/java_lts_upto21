package level03_advanced.jdk21.patternmatchingforswitch;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 6: cover every permitted type in a switch over a sealed hierarchy. */
public class PatternSwitch06SealedExhaustive {
    sealed interface Expr permits Value, Sum, Negate { }
    record Value(int number) implements Expr { }
    record Sum(Expr left, Expr right) implements Expr { }
    record Negate(Expr expression) implements Expr { }

    static int evaluate(Expr expression) {
        return switch (expression) {
            case Value value -> value.number();
            case Sum sum -> evaluate(sum.left()) + evaluate(sum.right());
            case Negate negate -> -evaluate(negate.expression());
        };
    }

    public static void main(String[] args) {
        Expr expression = new Sum(new Value(10), new Negate(new Value(3)));
        System.out.println(evaluate(expression)); // 7
    }
}