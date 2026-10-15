package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;
import java.time.Duration;

/*
 * Program purpose:
 * - Proper HTTP GET request
 * - Status handling
 * - Timeout handling
 * - JSON response printing without external libraries
 */
/**
 * Easy: Demonstrates Http Client Api06 Get With Timeout And Status Check in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi06GetWithTimeoutAndStatusCheck {

    public static void main(String[] args) {

        try {
            // 1. Create reusable HttpClient with timeout
            HttpClient client = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // 2. Build HTTP GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://postman-echo.com/get"))
                    .timeout(Duration.ofSeconds(10))
                    .GET()
                    .build();

            // 3. Send request (blocking)
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            // 4. Check HTTP status code
            if (response.statusCode() != 200) {
                System.out.println("Request failed with status: " + response.statusCode());
                return;
            }

            // 5. Print JSON response.
            // The JDK HTTP Client returns the response body as text here.
            // Pretty JSON formatting would need a library such as Jackson or Gson,
            // so this example stays JDK-only for easy compilation.
            System.out.println(response.body());

        } catch (Exception e) {
            // 6. Handle network errors
            System.out.println("Error occurred:");
            e.printStackTrace();
        }
    }
}
