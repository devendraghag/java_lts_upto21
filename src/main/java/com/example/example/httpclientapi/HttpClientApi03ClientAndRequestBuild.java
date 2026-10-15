package level03_advanced.jdk11.httpclientapi;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

/*
 * JDK 11 introduction-version bucket interview program: HttpClient request construction.
 *
 * This program only builds the client and request. It does not send a network call.
 *
 * Interview point:
 * - HttpClient is reusable and thread-safe.
 * - HttpRequest is immutable after build().
 * - Timeouts should be set explicitly in real applications.
 */
/**
 * Easy: Demonstrates Http Client Api03 Client And Request Build in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi03ClientAndRequestBuild {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com"))
                .timeout(Duration.ofSeconds(5))
                .header("Accept", "application/json")
                .GET()
                .build();

        System.out.println(client.version());
        System.out.println(request.method());
        System.out.println(request.uri());
    }
}

