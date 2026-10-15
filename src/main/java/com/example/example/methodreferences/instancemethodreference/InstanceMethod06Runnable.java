package com.example.methodreferences.instancemethodreference;

/** Medium: Runnable has no inputs and returns void, matching a no-argument object method. */
public class InstanceMethod06Runnable {
    static class Task {
        void execute() {
            System.out.println("Task executed");
        }
    }

    public static void main(String[] args) {
        Task task = new Task();
        Runnable lambda = () -> task.execute();
        Runnable reference = task::execute;

        lambda.run();
        reference.run();
    }
}
