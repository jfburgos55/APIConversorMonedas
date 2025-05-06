package lad.com.alura.conversormonedas.conversorapi;

public class ConversorMonedaAPI {
    private ConversorMonedaAPI api;

    public ConversorMonedaAPI(ConversorMonedaAPI api) {
        this.api = api;
    }

    public double convert(Moneda from, Moneda to, double amount) throws Exception {
        // Validar datos
        if (amount <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }

        // Llamar a la API para obtener la tasa de conversión
        double exchangeRate = api.getExchangeRate(from.getCode(), to.getCode());

        // Realizar la conversión
        return amount * exchangeRate;
    }
}
