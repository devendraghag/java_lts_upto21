package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.lang.annotation.*;
import java.util.List;

// Custom annotation that can be applied to parameters
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
/**
 * Easy: Demonstrates Var Lambda Parameter08 Custom Annotation Audit in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
@interface Audited {}

public class VarLambdaParameter08CustomAnnotationAudit {

    public static void main(String[] args) {

        List<String> items = List.of("order1", "order2");

        // Applying custom annotation to lambda parameter
        // Useful for logging, auditing, security, static analysis
        items.forEach((@Audited var item) -> process(item));
    }

    static void process(String item) {
        System.out.println("Processing: " + item);
    }
}
