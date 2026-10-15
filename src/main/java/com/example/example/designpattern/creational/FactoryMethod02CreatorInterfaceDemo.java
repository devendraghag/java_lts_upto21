package com.example.designpattern.creational;

// Factory Method with creator and product interfaces instead of creator inheritance.
public class FactoryMethod02CreatorInterfaceDemo {
    interface Notification { void send(String message); }
    interface NotificationCreator {
        Notification createNotification(); // Factory Method
        default void notifyUser(String message) {
            createNotification().send(message); // Shared workflow uses the product interface.
        }
    }

    static class EmailNotification implements Notification {
        public void send(String message) { System.out.println("Email: " + message); }
    }
    static class SmsNotification implements Notification {
        public void send(String message) { System.out.println("SMS: " + message); }
    }
    static class EmailCreator implements NotificationCreator {
        public Notification createNotification() { return new EmailNotification(); }
    }
    static class SmsCreator implements NotificationCreator {
        public Notification createNotification() { return new SmsNotification(); }
    }

    public static void main(String[] args) {
        NotificationCreator creator = new EmailCreator();
        creator.notifyUser("Your order is ready");
        creator = new SmsCreator();
        creator.notifyUser("Your order is ready");
    }
}
