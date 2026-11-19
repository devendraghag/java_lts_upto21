package com.example.association;

/** A service uses an independently-owned collaborator through an interface. */
public class Association04DependencyInjection {
    public static void main(String[] args) {
        NotificationService service = new NotificationService(new ConsoleSender());
        service.notifyUser("Nia", "Your order is ready.");
    }
    private interface MessageSender { void send(String recipient, String message); }
    private static final class ConsoleSender implements MessageSender {
        @Override public void send(String recipient, String message) {
            System.out.println("To " + recipient + ": " + message);
        }
    }
    private static final class NotificationService {
        private final MessageSender sender;
        private NotificationService(MessageSender sender) { this.sender = sender; }
        private void notifyUser(String recipient, String message) { sender.send(recipient, message); }
    }
}
