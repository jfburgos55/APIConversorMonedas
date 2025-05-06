/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lad.com.alura.conversormoneda.apiconversormonedas.modelos;

/**
 *
 * @author jfburgos55
 */
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    private final String apiUrl = "https://api.fastforex.io/fetch-one?from=";
    private final String apiKey = "e6dca4dc97-0289a09959-svpnr5";

    public Monedas buscarMonedas(String base, String result) {
        // Validar que los parámetros no sean nulos o vacíos
        if (base == null || base.isEmpty() || result == null || result.isEmpty()) {
            throw new IllegalArgumentException("Base y Result no pueden ser nulos o vacíos");
        }

        // Construir la URI
        URI direccion = URI.create(apiUrl
                + base + "&to=" 
                + result + "&api_key=" 
                + apiKey);

        // Crear cliente HTTP
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Enviar la solicitud y recibir la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Deserializar el JSON en un objeto Monedas
            return new Gson().fromJson(response.body(), Monedas.class);
        } catch (JsonSyntaxException | IOException | InterruptedException e) {
            // Manejo de errores
            throw new RuntimeException("No se encontró la moneda o hubo un error: " + e.getMessage(), e);
        }
    }
}