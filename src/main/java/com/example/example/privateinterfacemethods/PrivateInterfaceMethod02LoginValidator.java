package level03_advanced.jdk09.privateinterfacemethods;
// JDK history: Introduction baseline: JDK 9 (the release bucket for this topic).


/**
 * Easy: Demonstrates Private Interface Method02 Login Validator in the Private Interface Methods topic.
 * Inspect the commented example to see which usage the compiler rejects.
 * Medium: Identify the exact compiler rule before checking the commented invalid statement.
 * Tough: Explain the compile-time failure precisely, then state the smallest valid correction.
 */
interface Authenticator {

    default void login(String username, String password) {
        if (isValid(username, password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Credentials.");
        }
    }

    private boolean isValid(String username, String password) {
        return "admin".equals(username) && "password123".equals(password);
    }
}

public class PrivateInterfaceMethod02LoginValidator implements Authenticator {
    public static void main(String[] args) {
        PrivateInterfaceMethod02LoginValidator app = new PrivateInterfaceMethod02LoginValidator();
        app.login("admin", "password123");
        app.login("user", "wrongpass");
    }
}
