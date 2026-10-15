package com.example.cohesion;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Sequential cohesion: the output from one step is used as the input to the next.
 */
public class CohesionType02Sequential {
    static class RegistrationPipeline {
        String prepareWelcomeMessage(String rawName) {
            String cleanedName = removeExtraSpaces(rawName);
            String validName = checkName(cleanedName);
            return createMessage(validName);
        }

        private String removeExtraSpaces(String name) {
            return name.trim().replaceAll("\\s+", " ");
        }

        private String checkName(String name) {
            if (name.isEmpty()) {
                return "Guest";
            }
            return name;
        }

        private String createMessage(String name) {
            return "Welcome, " + name + "!";
        }
    }

    public static void main(String[] args) {
        RegistrationPipeline pipeline = new RegistrationPipeline();
        System.out.println(pipeline.prepareWelcomeMessage("  Asha    Rao  "));
    }
}
