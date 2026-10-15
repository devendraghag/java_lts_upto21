package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;

/*
 * Program purpose:
 * - Understand HTTP metadata
 * - Status codes and headers
 */
/**
 * Easy: Demonstrates Http Client Api05 Status And Headers in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi05StatusAndHeaders {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/get"))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Headers:");
        response.headers().map().forEach(
                (k, v) -> System.out.println(k + " = " + v)
        );
    }
}
