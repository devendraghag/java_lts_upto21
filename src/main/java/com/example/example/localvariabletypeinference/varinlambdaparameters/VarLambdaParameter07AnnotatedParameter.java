package level03_advanced.jdk11.localvariabletypeinference.varinlambdaparameters;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Easy: Demonstrates Var Lambda Parameter07 Annotated Parameter in the Local Variable Type Inference / Var In Lambda Parameters topic.
 * Run it to observe the basic behavior and output.
 * Medium: Trace each pipeline or callback step, then predict when evaluation happens and what it returns.
 * Tough: Explain laziness, encounter order, side effects, and whether the result remains correct for empty input.
 */
@interface Nonnull {
}

public class VarLambdaParameter07AnnotatedParameter {

    public static void main(String[] args) {

        List<String> emails = List.of("a@test.com", "b@test.com");

        // Using annotation on lambda parameter
        // This is NOT possible without 'var'
        emails.forEach((@Nonnull var email) -> {

            // email is inferred as String
            System.out.println(email.toLowerCase());
        });
    }
}
