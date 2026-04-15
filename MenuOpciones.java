import java.util.Scanner;

public class MenuOpciones {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE USUARIO ---");
            System.out.println("1. Saludar");
            System.out.println("2. Ver saldo (simulado)");
            System.out.println("3. Salir");
            System.out.println("Selecciona una opción: ");

            opcion = entrada.nextInt();

            if (opcion == 1) {
                System.out.println("¡Hola! espero que tengas un gran dia.");
            } else if (opcion == 2) {
                System.out.println("Tu saldo actual es: $5000");
            } else if (opcion != 3) {
                System.out.println("Opcion no válida, Intenta de nuevo.");
            }
        } while (opcion != 3); //El ciclo sigue mientras la opcion no sea 3

        System.out.println("Programa finalizado. ¡Adiós!");

        entrada.close();
    }

    
}
