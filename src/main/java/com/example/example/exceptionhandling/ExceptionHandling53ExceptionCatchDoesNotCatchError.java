package com.example.example.exceptionhandling;

/** INTERVIEW TRAP 53: catch(Exception) does not catch Error. */
public class ExceptionHandling53ExceptionCatchDoesNotCatchError {
    public static void main(String[] args) {
        try {
            throw new AssertionError("An Error is not an Exception");
        } catch (Exception exception) {
            System.out.println("This does not catch AssertionError");
        } catch (Error error) {
            // Catching Error here keeps the demo controlled; applications rarely handle Errors as routine failures.
            System.out.println("Caught separately: " + error.getClass().getSimpleName());
        }
    }
}
