package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;

/*
 * Program purpose:
 * - Send JSON payload
 * - Understand headers and body publishers
 */
/**
 * Easy: Demonstrates Http Client Api11 Post Json Body in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi11PostJsonBody {

    public static void main(String[] args) throws Exception {

        // Text blocks arrived later (JDK 15), so this JDK 11 example uses
        // ordinary string concatenation.
        String json = "{\n"
                + "  \"name\": \"Java\",\n"
                + "  \"version\": 11,\n"
                + "  \"lts\": true\n"
                + "}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Response JSON:");
        System.out.println(response.body());
    }
}
