package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/** MEDIUM 9/17: Define and handle a custom checked business exception. */
class AgeRequirementException extends Exception {
    private static final long serialVersionUID = 1L;

    AgeRequirementException(String message) {
        super(message);
    }
}

public class ExceptionHandling09CustomCheckedException {
    private static void registerVoter(int age) throws AgeRequirementException {
        if (age < 18) {
            throw new AgeRequirementException("A voter must be at least 18 years old.");
        }
        System.out.println("Voter registration accepted.");
    }

    public static void main(String[] args) {
        try {
            registerVoter(16);
        } catch (AgeRequirementException exception) {
            System.out.println("Registration rejected: " + exception.getMessage());
        }
    }
}
