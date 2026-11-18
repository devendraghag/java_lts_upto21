package com.example.example.exceptionhandling;

/** INTERVIEW TRAP 54: InterruptedException clears the interrupt status when it is thrown. */
public class ExceptionHandling54InterruptedExceptionTrap {
    public static void main(String[] args) {
        Thread current = Thread.currentThread();
        current.interrupt();

        try {
            Thread.sleep(1);
        } catch (InterruptedException exception) {
            System.out.println("Flag after InterruptedException: " + current.isInterrupted());

            // If this method cannot propagate InterruptedException, restore the flag
            // so higher-level code can still see the interruption request.
            current.interrupt();
        }

        System.out.println("Flag after restoring it: " + current.isInterrupted());
    }
}
