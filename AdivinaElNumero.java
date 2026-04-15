import java.util.Scanner;
import java.util.Random;

public class AdivinaElNumero {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random aleatorio = new Random();
        
        int numeroSecreto = aleatorio.nextInt(100) + 1; // Genera un número del 1 al 100
        int intento = 0;
        int contador = 0;

        System.out.println("¡He pensado un número entre 1 y 100! ¿Puedes adivinarlo?");

        // Este bucle se repite mientras no adivines
        while (intento != numeroSecreto) {
            System.out.print("Introduce tu número: ");
            intento = lector.nextInt();
            contador++;

            if (intento < numeroSecreto) {
                System.out.println("Es más alto... ¡Intenta otra vez!");
            } else if (intento > numeroSecreto) {
                System.out.println("Es más bajo... ¡Intenta otra vez!");
            } else {
                System.out.println("¡BRUTAL! Lo lograste en " + contador + " intentos.");
            }
        }

        lector.close();
    }
}