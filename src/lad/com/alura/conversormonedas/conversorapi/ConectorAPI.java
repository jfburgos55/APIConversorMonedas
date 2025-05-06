package lad.com.alura.conversormonedas.conversorapi;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConectorAPI {
    private static final String API_URL = "https://api.fastforex.io/fetch-all?api_key=e6dca4dc97-0289a09959";
    public double getExchangeRate(String from, String to) throws Exception {
        // Crear URL dinámica para la API
        String url = API_URL + from;

        // Realizar la solicitud HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Validar respuesta
        if (response.statusCode() != 200) {
            throw new Exception("Error al obtener los datos de la API.");
        }

        // Procesar JSON usando GSON
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        if (!json.has("rates") || !json.getAsJsonObject("rates").has(to)) {
            throw new Exception("No se encontró la tasa de conversión para la moneda: " + to);
        }

        return json.getAsJsonObject("rates").get(to).getAsDouble();
    }


}
