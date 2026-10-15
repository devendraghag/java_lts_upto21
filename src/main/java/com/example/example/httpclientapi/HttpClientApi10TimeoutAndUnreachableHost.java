package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;
import java.time.Duration;

/*
 * Program purpose:
 * - Handle timeout and unreachable host
 * - Understand exception scenarios
 */
/**
 * Easy: Demonstrates Http Client Api10 Timeout And Unreachable Host in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi10TimeoutAndUnreachableHost {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(2))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://10.255.255.1")) // unreachable
                .timeout(Duration.ofSeconds(2))
                .build();

        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println("Network/Timeout error:");
            System.out.println(e.getClass().getSimpleName());
        }
    }
}
