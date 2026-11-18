package com.example.example.exceptionhandling;

/** INTERVIEW TRAP 52: throwing null does not throw a null reference; it produces NullPointerException. */
public class ExceptionHandling52ThrowNullTrap {
    public static void main(String[] args) {
        try {
            throw null;
        } catch (NullPointerException exception) {
            System.out.println("throw null caused: " + exception.getClass().getSimpleName());
        }
    }
}
