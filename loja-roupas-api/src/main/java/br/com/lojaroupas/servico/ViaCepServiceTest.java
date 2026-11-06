package br.com.lojaroupas.servico;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepServiceTest {
    public static void main(String[] args) {
        try {
            String cep = "41830050"; 
            String url = "https://viacep.com.br/ws/" + cep + "/json/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Resposta da API ViaCEP: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}