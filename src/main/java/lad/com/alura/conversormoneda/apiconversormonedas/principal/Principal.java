package lad.com.alura.conversormoneda.apiconversormonedas.principal;

import java.util.Scanner;
import lad.com.alura.conversormoneda.apiconversormonedas.modelos.ConsultarMoneda;
import lad.com.alura.conversormoneda.apiconversormonedas.modelos.ConvertirMoneda;

/**
 *
 * @author jfburgos55
 */
public class Principal {

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();

        System.out.println("------------------------------------------------------------------------");
        System.out.println("* API CONVERSOR DE MONEDAS ");
        System.out.println("------------------------------------------------------------------------");

        int opcion = 0;
        while (opcion != 7) {

            System.out.println("\n* MENU Conversor Monedas *");
            System.out.println("""
                 \n1. USD to ARS - (Dolar -> Peso Argentino)
                 2. ARS to USD - (Peso Argentino -> Dolar)
                 3. USD to BRL - (Dolar -> Real Brasileño)
                 4. BRL to USD - (Real Brasileño -> Dolar)
                 5. USD to COP - (Dolar -> Peso Colombiano)
                 6. COP to USD - (Peso Colombiano -> Dolar)
                 7. Salir
                 """);
  
            System.out.println("\nIngrese la opción deseada: ");

            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    ConvertirMoneda.convertir("USD", "ARS", consulta, lectura);
                    break;
                case 2:
                    ConvertirMoneda.convertir("ARS", "USD", consulta, lectura);
                    break;
                case 3:
                    ConvertirMoneda.convertir("USD", "BRL", consulta, lectura);
                    break;
                case 4:
                    ConvertirMoneda.convertir("BRL", "USD", consulta, lectura);
                    break;
                case 5:
                    ConvertirMoneda.convertir("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    ConvertirMoneda.convertir("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    System.out.println("Gracias por usar el conversor");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    throw new AssertionError();
            }

        }
    }
}
