package level03_advanced.jdk21.recordpatterns;
// JDK history: Introduction baseline: JDK 21 (the release bucket for this topic).

/** Level 3: var component patterns infer their types from the record declaration. */
public class RecordPattern03VarPatterns {
    record Person(String name, int age) { }

    public static void main(String[] args) {
        Object value = new Person("Asha", 28);

        if (value instanceof Person(var name, var age)) {
            System.out.println(name.toUpperCase()); // ASHA
            System.out.println(age + 1);            // 29
        }
    }
}