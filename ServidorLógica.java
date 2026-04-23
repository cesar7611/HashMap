import java.util.Scanner;

// Definimos la clase principal del programa
public class ServidorLógica {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Introduce las peticiones actuales: ");
        // 1. Declaramos la variable que simula el tráfico actual del servidor
        int peticionesActuales = leer.nextInt(); 

        // 2. Iniciamos la estructura condicional para tomar una decisión
        // El símbolo '>=' significa 'mayor o igual que'
        if (peticionesActuales >= 100) { 
            
            // Si la condición se cumple, ejecutamos este bloque de alerta
            System.out.println("⚠️ Alerta: Servidor saturado");
            
        } else { 
            
            // Si la condición NO se cumple, calculamos cuánto espacio queda
            int espacioLibre = 100 - peticionesActuales;
            
            // Mostramos el estado usando 'concatenación' (unir texto con variables)
            // Nota los espacios dentro de las comillas para que el texto no salga pegado
            System.out.println("✅ Estado: Servidor Disponible. Quedan " + espacioLibre + " lugares.");
            
        } // Fin del bloque else
        
    } // Fin del método principal (main)
} // Fin de la clase
