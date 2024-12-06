package org.example.cli;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ApiClient {
    private static final String BASE_URL = "http://localhost:8080/api/v1/tickets";

    public static void saveTicket() throws Exception{
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(BASE_URL+"/startVendor")).POST(HttpRequest.BodyPublishers.noBody()).build();

        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println("Response:"+ response.body());

    }


}
