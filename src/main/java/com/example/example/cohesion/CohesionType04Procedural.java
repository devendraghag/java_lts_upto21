package com.example.cohesion;
// JDK history: Introduced in JDK 1.0; this directory marks the introduction baseline for the topic.

/**
 * Procedural cohesion: actions are grouped because they must happen in a
 * particular order, even though each action has a different small purpose.
 */
public class CohesionType04Procedural {
    static class LoginProcedure {
        void logIn(String userName) {
            checkInput(userName);       // Step 1 must happen first.
            loadUserProfile(userName);  // Step 2 follows validation.
            showHomePage(userName);     // Step 3 follows profile loading.
        }

        private void checkInput(String userName) {
            System.out.println("1. Check login input for " + userName);
        }

        private void loadUserProfile(String userName) {
            System.out.println("2. Load profile for " + userName);
        }

        private void showHomePage(String userName) {
            System.out.println("3. Show home page for " + userName);
        }
    }

    public static void main(String[] args) {
        new LoginProcedure().logIn("Mina");
    }
}
