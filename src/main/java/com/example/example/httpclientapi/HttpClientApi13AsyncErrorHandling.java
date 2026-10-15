package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;

/*
 * Program purpose:
 * - Handle async errors
 * - Invalid URL scenario
 */
/**
 * Easy: Demonstrates Http Client Api13 Async Error Handling in the Http Client API topic.
 * Inspect the commented example to see which usage the compiler rejects.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi13AsyncErrorHandling {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://invalid-url"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
              .exceptionally(ex -> {
                  System.out.println("Async failure:");
                  System.out.println(ex.getMessage());
                  return null;
              })
              .join();
    }
}
