package level03_advanced.jdk11.httpclientapi;
// JDK history: Introduction baseline: JDK 11 (the release bucket for this topic).


import java.net.URI;
import java.net.http.*;
import java.nio.file.Path;

/*
 * Program purpose:
 * - Handle binary responses
 * - Download files
 */
/**
 * Easy: Demonstrates Http Client Api14 File Download Body Handler in the Http Client API topic.
 * Run it to observe the basic behavior and output.
 * Medium: Follow the input, API operation, resource lifecycle, and produced output.
 * Tough: Analyze failure handling, resource ownership, security boundaries, partial operations, and portability.
 */
public class HttpClientApi14FileDownloadBodyHandler {

    public static void main(String[] args) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://postman-echo.com/bytes/2048"))
                .build();

        client.send(
                request,
                HttpResponse.BodyHandlers.ofFile(Path.of("download.bin"))
        );

        System.out.println("File downloaded successfully");
    }
}
