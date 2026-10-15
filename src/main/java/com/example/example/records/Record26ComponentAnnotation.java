package level03_advanced.jdk16.records;
// JDK history: Records were previewed in JDK 14 and 15, then finalized in JDK 16.

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.RecordComponent;

/**
 * Easy: Demonstrates Record26 Component Annotation in the Records topic.
 * Run it to observe the basic behavior and output.
 * Medium: Compare the concise feature syntax with the runtime behavior printed by the example.
 * Tough: Check canonical-constructor rules, equality semantics, and why record components provide only shallow immutability.
 */
public class Record26ComponentAnnotation {
    @Target(ElementType.RECORD_COMPONENT)
    @Retention(RetentionPolicy.RUNTIME)
    @interface Label {
        String value();
    }

    record User(@Label("user identifier") long id, String name) {
    }

    public static void main(String[] args) {
        RecordComponent component = User.class.getRecordComponents()[0];
        System.out.println(component.getName() + "="
                + component.getAnnotation(Label.class).value());
    }
}
