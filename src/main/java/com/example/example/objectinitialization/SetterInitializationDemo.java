package com.example.objectinitialization;

/** Demonstrates setter-based initialization and the possibility of partial state. */
public class SetterInitializationDemo {
    private static final class UserProfile {
        private String username;
        private String email;

        private void setUsername(String username) {
            this.username = username;
        }

        private void setEmail(String email) {
            this.email = email;
        }

        private boolean isComplete() {
            return username != null && email != null;
        }
    }

    public static void main(String[] args) {
        UserProfile profile = new UserProfile();
        profile.setUsername("asha");
        System.out.println("Complete after one setter: " + profile.isComplete());
        profile.setEmail("asha@example.com");
        System.out.println("Complete after both setters: " + profile.isComplete());
    }
}
