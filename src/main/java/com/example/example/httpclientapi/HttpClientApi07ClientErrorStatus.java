package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;

/*
 * Program purpose:
 * - Learn that HttpClient does NOT throw exception for 4xx/5xx
 * - You must check status code manually
 */
/**
 * Easy: Demonstrates Http Client Api07 Client Error Status in the Http Client API topic.
 * Inspect the commented example to see which usage the compiler rejects.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi07ClientErrorStatus {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/status/404"))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() >= 400) {
            System.out.println("Client error occurred: " + response.statusCode());
        }
    }
}
