package level03_advanced.jdk17.sealedclasses;
// JDK history: Sealed classes and interfaces were previewed in JDK 15 and 16, then finalized in JDK 17.

/** Level 4: permits may be omitted when permitted types are in the same source file. */
public class SealedClasses04ImplicitPermits {
    sealed interface Signal { }

    record Click(int x, int y) implements Signal { }
    record KeyPress(String key) implements Signal { }

    public static void main(String[] args) {
        Signal first = new Click(10, 20);
        Signal second = new KeyPress("Enter");

        System.out.println(first);
        System.out.println(second);
        // Click and KeyPress are the implicitly permitted direct implementations.
    }
}