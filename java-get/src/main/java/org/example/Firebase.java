package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Firebase {

    private static final String URL_POST = "https://hnproject-e95d9-default-rtdb.firebaseio.com/tasks.json";

    public static void post(String data) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

    }

    public static void get() throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Pressione ENTER para buscar tarefas: ");
        in.nextLine();

        URL url = new URL("https://hnproject-e95d9-default-rtdb.firebaseio.com/tasks.json");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");

        var responseStream = connection.getInputStream();

        String response = new BufferedReader(new InputStreamReader(responseStream))
                .lines().collect(Collectors.joining("\n"));

        System.out.println(response);

    }

}
