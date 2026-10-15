package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;

/*
 * Program purpose:
 * - Follow HTTP redirects automatically
 */
/**
 * Easy: Demonstrates Http Client Api15 Redirect Config in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi15RedirectConfig {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://google.com"))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Redirect handled successfully");
        System.out.println("Status: " + response.statusCode());
    }
}
