package com.example.abstractclass;

/** Abstract references can point to different concrete subclasses. */
public class AbstractClass06RuntimePolymorphismDemo {
    public static void main(String[] args) {
        Notification[] notifications = {new Email("Hello"), new Sms("Meeting at 3")};
        for (Notification notification : notifications) {
            notification.send();
        }
    }

    private abstract static class Notification {
        private final String message;

        protected Notification(String message) {
            this.message = message;
        }

        protected String message() {
            return message;
        }

        public abstract void send();
    }

    private static final class Email extends Notification {
        private Email(String message) { super(message); }
        @Override public void send() { System.out.println("Email: " + message()); }
    }

    private static final class Sms extends Notification {
        private Sms(String message) { super(message); }
        @Override public void send() { System.out.println("SMS: " + message()); }
    }
}
