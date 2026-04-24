import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class SistemaDePrestamos {
    public static void main(String[] args) {

        HashMap<String, String> nombre = new HashMap<>();
        HashMap<String, Double> precio = new HashMap<>();
        HashMap<String, Integer> stock = new HashMap<>();

        nombre.put("drama", "Titanic");
        precio.put("drama", 7.00);
        stock.put("drama", 11);

        nombre.put("terror", "calle13");
        precio.put("terror", 6.00);
        stock.put("terror", 6);

        nombre.put("acción", "RapidoyFurioso");
        precio.put("acción", 12.00);
        stock.put("acción", 3);

        Scanner entrada = new Scanner(System.in);
        boolean continuar = true;
        double totalVentasDia = 0; // Nuestra "alcancía" para el total recaudado

        while (continuar) {
            System.out.println("\n>>> SISTEMA DE RENTA <<<");
            System.out.println("Escriba la categoría o 'salir' para cerrar caja.");

            System.out.println("\n¿Qué categoría desea rentar?");
            String pedido = entrada.next().toLowerCase();

            if (pedido.equals("salir")) {
                continuar = false;
            } else if (precio.containsKey(pedido)) {
                int cantidadActual = stock.get(pedido);

                if (cantidadActual > 0) {
                    System.out.println("Precio: $" + precio.get(pedido) + " | Stock: " + cantidadActual);
                    System.out.println("¿Cuántas unidades?");
                    int unidadesPedidas = entrada.nextInt();

                    if (unidadesPedidas <= cantidadActual) {
                        double subtotal = unidadesPedidas * precio.get(pedido);

                        // Actualizamos el stock y la recaudación del día
                        stock.put(pedido, cantidadActual - unidadesPedidas);
                        totalVentasDia += subtotal; // Sumamos al total global

                        // Obtener la fecha y hora actual
                        LocalDateTime ahora = LocalDateTime.now();
                        // Darle un formato bonito (Día/Mes/Año Hora:Minuto)
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

                        System.out.println("\n--- TICKET DE RENTA ---");
                        System.out.println("Fecha: " + ahora.format(formato)); // <--- Aquí se muestra
                        System.out.println("Pelicula: " + nombre.get(pedido));
                        System.out.println("Subtotal: $" + subtotal);
                    } else {
                        System.out.println("Error: Stock insuficiente.");
                    }
                } else {
                    System.out.println("Lo sentimos, sin existencias.");
                }
            } else {
                System.out.println("Categoría no encontrada.");
            }
        }

        // Resumen al salir del bucle
        System.out.println("\n===============================");
        System.out.println("   RESUMEN DE CIERRE DE CAJA   ");
        System.out.println("===============================");
        System.out.println("Total recaudado hoy: $" + totalVentasDia);
        System.out.println("¡Gracias por usar el sistema!");

        entrada.close();
    }
}
