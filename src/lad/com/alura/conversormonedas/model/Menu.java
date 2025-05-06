package lad.com.alura.conversormonedas.model;

import java.util.Scanner;

public class Menu {
    public Menu() {
        try{
            Scanner lectura = new Scanner(System.in);
            while(true){
                System.out.println(" ------ MENU Conversor Monedas ------");
                System.out.println("""
               1. Peso Colombiano (COP) -> Dolar (USD)
               2. Peso Colombiano (COP) -> Euro (EUR)
               3. Peso Colombiano (COP) -> Peso Argentino (ARS)
               4. Salir
                """);

                System.out.println("Digite en numero la opción: ");
                var opcion = Integer.valueOf(lectura.nextLine());

                if(opcion == 4){
                    System.out.println("Gracias por usar el conversor!!");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Recuerda que debes digitar un número: " + e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
