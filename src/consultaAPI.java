import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;

public class consultaAPI {

    // Método para convertir moneda usando la API de Exchangerate
    public static void convertirMoneda(String monedaOrigen, String monedaSalida, double cantidad) {
        try {
            // Construimos la URL para consultar la API
            String direccion = "https://v6.exchangerate-api.com/v6/2e166dded22f8ff15e7f288d/latest/" + monedaOrigen;
            HttpClient client = HttpClient.newHttpClient(); // Creamos un cliente HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Obtenemos la respuesta en formato JSON
            String jsonResponse = response.body();
            Gson gson = new Gson(); // Usamos GSON para parsear el JSON
            JsonObject json = gson.fromJson(jsonResponse, JsonObject.class);
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            // Validamos que la moneda de destino esté en la respuesta
            if (!rates.has(monedaSalida)) {
                throw new IllegalArgumentException("La moneda de salida no es válida.");
            }

            // Calculamos la conversión
            double tasaMonedaDestino = rates.get(monedaSalida).getAsDouble();
            double resultado = cantidad * tasaMonedaDestino;

            // Formateamos el resultado para una mejor presentación
            DecimalFormat df = new DecimalFormat("#.###");
            String resultadoFormateado = df.format(resultado);
            System.out.println(cantidad + " " + monedaOrigen + " equivale a " + resultadoFormateado + " " + monedaSalida);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
