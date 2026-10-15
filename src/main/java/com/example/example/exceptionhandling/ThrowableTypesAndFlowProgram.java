package com.example.exceptionhandling;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Easy: Demonstrates Throwable Types And Flow Program in the Exception Handling topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow normal and exceptional control flow, including which cleanup code runs and what is reported.
 * Tough: Determine the primary exception, suppressed exceptions, return behavior, and resource-closing order.
 */
class BusinessException extends Exception {
    BusinessException(String message) { super(message); }
}

class BusinessRuntimeException extends RuntimeException {
    BusinessRuntimeException(String message) { super(message); }
}

public class ThrowableTypesAndFlowProgram {
    private static void checkedFailure() throws BusinessException {
        throw new BusinessException("checked failure");
    }

    private static void rethrow() throws BusinessException {
        try {
            checkedFailure();
        } catch (BusinessException exception) {
            System.out.println("caught before rethrow");
            throw exception;
        } finally {
            System.out.println("finally during stack unwinding");
        }
    }

    public static void main(String[] args) {
        try {
            rethrow();
        } catch (BusinessException exception) {
            System.out.println(exception.getMessage());
        }
        try {
            throw new BusinessRuntimeException("unchecked failure");
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
        Throwable[] hierarchy = {new Error("error"), new Exception("exception"), new RuntimeException("runtime")};
        System.out.println("hierarchy size=" + hierarchy.length);
    }
}
