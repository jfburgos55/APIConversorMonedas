/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lad.com.alura.conversormoneda.apiconversormonedas.modelos;

import java.util.Scanner;
/**
 *
 * @author jfburgos55
 */
public class ConvertirMoneda {

    public static void convertir(String base, String result, ConsultarMoneda consulta, Scanner lectura) {
        double cantidad;
        double cantidadConvertida;

        // Consultar las monedas
        Monedas monedas = consulta.buscarMonedas(base, result);

        // Obtener la tasa de conversión
        Double tasaConversion = monedas.getResult().get(result);

        if (tasaConversion == null) {
            System.out.println("No se encontró una tasa de conversión para " + base + " a " + result);
            return;
        }

        // Mostrar la tasa de conversión
        System.out.println("La tasa de conversión para hoy:");
        System.out.println("1 " + base + " = " + tasaConversion + " " + result);

        // Leer la cantidad de monedas
        System.out.print("Ingrese la cantidad de monedas (" + base + "): ");
        try {
            cantidad = Double.parseDouble(lectura.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido.");
            return;
        }

        // Calcular la cantidad convertida
        cantidadConvertida = cantidad * tasaConversion;

        // Mostrar el resultado
        System.out.println(cantidad + " " + base + " = " + cantidadConvertida + " " + result);
        System.out.println("------------------------------------------------------------------------");
    }

}