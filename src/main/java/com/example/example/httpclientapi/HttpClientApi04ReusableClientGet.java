package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;

/*
 * Program purpose:
 * - Demonstrate best practice
 * - HttpClient is thread-safe and reusable
 */
/**
 * Easy: Demonstrates Http Client Api04 Reusable Client Get in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi04ReusableClientGet {

    private static final HttpClient CLIENT =
            HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/get"))
                .build();

        HttpResponse<String> response =
                CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
