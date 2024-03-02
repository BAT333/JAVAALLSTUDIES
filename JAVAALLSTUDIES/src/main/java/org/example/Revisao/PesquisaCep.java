package org.example.Revisao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PesquisaCep {
    public static String Endereco(String cep){
        String endereco = "";
        try {


            URI uri = URI.create("https://viacep.com.br/ws/" + cep + "/json/");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            endereco = response.body();

        }catch (IOException | InterruptedException ex){
            throw new RuntimeException(ex);
        }
        return endereco;
    }

}
