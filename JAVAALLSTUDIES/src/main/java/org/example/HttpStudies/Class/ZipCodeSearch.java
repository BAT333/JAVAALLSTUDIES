package org.example.HttpStudies.Class;

import org.example.HttpStudies.ExceptionZipCod.ExceptionsZipcod;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface ZipCodeSearch {

    public static  String Search(String zipCode){

        Pattern regex = Pattern.compile("[A-Za-z]");
        Matcher matcher = regex.matcher(zipCode);
        String zioCod ="";
        try {

            if (zipCode.length() != 8 || matcher.find()) {
                throw new ExceptionsZipcod("ERROR WHEN TYPING ZIP CODE");
            }
            URI uri = URI.create("https://viacep.com.br/ws/01001000/json/");
            //RESUMINDO
            //A classe HttpClient é responsável por fazer requisições HTTP.
            //A classe HttpRequest é utilizada para construir uma requisição HTTP.
            //A classe HttpResponse é responsável por armazenar a resposta da requisição HTTP.
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(uri).build();
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            zioCod +=response.body();
        }catch (ExceptionsZipcod | InterruptedException | IOException  ex){
          System.out.println(ex);

        }

        return zioCod;
    }
}
