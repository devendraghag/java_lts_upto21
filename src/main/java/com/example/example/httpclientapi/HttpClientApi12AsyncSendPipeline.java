package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;

/*
 * Program purpose:
 * - Non-blocking HTTP call
 * - CompletableFuture pipeline
 */
/**
 * Easy: Demonstrates Http Client Api12 Async Send Pipeline in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi12AsyncSendPipeline {

    public static void main(String[] args) {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/get"))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
              .thenApply(HttpResponse::body)
              .thenAccept(System.out::println)
              .join(); // wait for async completion
    }
}
