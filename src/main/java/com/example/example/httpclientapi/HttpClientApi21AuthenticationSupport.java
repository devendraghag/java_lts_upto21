package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.http.HttpClient;

/**
 * Easy: Demonstrates Http Client Api21 Authentication Support in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi21AuthenticationSupport {
    public static void main(String[] args) {
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("student", "secret".toCharArray());
            }
        };

        HttpClient client = HttpClient.newBuilder()
                .authenticator(authenticator)
                .build();

        System.out.println("authenticatorConfigured=" + client.authenticator().isPresent());
        System.out.println("Credentials are supplied only after an authentication challenge.");
    }
}
