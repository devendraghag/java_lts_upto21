package level03_advanced.jdk11.httpclientapi;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;

/*
 * JDK 11 introduction-version bucket interview program: build an HttpRequest without network I/O.
 *
 * Interview point:
 * - HttpRequest is immutable after build().
 * - Timeouts and headers are part of request construction.
 */
/**
 * Easy: Demonstrates Http Client Api02 Request Build in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi02RequestBuild {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://example.com/orders"))
                .timeout(Duration.ofSeconds(2))
                .header("Accept", "application/json")
                .GET()
                .build();

        check(request.timeout().isPresent(), "Timeout should be present");
        System.out.println(request.method() + ":" + request.uri().getHost());
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new IllegalStateException(message);
        }
    }
}
