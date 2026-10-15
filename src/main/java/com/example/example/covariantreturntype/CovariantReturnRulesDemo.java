package com.example.covariantreturntype;

/** Shows the return-type rule and limits of covariant returns. */
public class CovariantReturnRulesDemo {
    public static void main(String[] args) {
        NumberSource source = new IntegerSource();
        Number value = source.value();
        System.out.println("Value: " + value);
        System.out.println("Concrete call type: " + new IntegerSource().value().getClass().getSimpleName());
    }

    private static class NumberSource {
        Number value() { return 0; }
    }

    private static class IntegerSource extends NumberSource {
        @Override
        Integer value() { return 21; } // Integer is a subtype of Number.
    }

    // For instance-method overriding, parameter types must still match.
    // Primitive return types must match exactly; int cannot be narrowed or widened covariantly.
    // The subtype return must be assignable to the overridden method's reference return type.
}
