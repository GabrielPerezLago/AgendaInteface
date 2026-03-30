package com.gabriel.agenda.agnedainterface.services;

import javafx.util.Pair;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HTTPService {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public HttpResponse<String> getContactos(String url) throws InterruptedException, IOException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/contactos"))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response;
    }

    public HttpResponse<String> createContactos(String url, String json) throws InterruptedException, IOException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/contactos/create"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        return response;
    }

    public HttpResponse<String> deleteContactos(String url, String json) throws InterruptedException, IOException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url + "/contactos/delete"))
                .header("Content-Type", "application/json")
                .method("DELETE" ,HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        return response;
    }
}
