package lad.com.alura.conversormonedas.principal;

import lad.com.alura.conversormonedas.conversorapi.*;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        //Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.print("Ingrese la moneda de origen (ej: USD): ");
        String fromMonedaCode = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda de destino (ej: EUR): ");
        String toMonedaCode = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        // Crear objetos de tipo Currency
        Moneda fromMoneda = new Moneda(fromMonedaCode);
        Moneda toMonedaCode = new Moneda(toMonedaCode);

        // Llamar al servicio de conversión
        ConversorMonedaAPI converterService = new ConversorMonedaAPI(new ConversorMonedaAPI());
        try {
            double result = converterService.convert(fromMoneda, toMonedaCode, amount);
            System.out.printf("Resultado: %.2f %s son %.2f %s%n", amount, fromMonedaCode, result, toMonedaCode);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}
