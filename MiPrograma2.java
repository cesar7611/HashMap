
// 1. PREPARACION DE HERRAMIENTAS
import java.util.HashMap; // Traes la herramienta de diccionario de Java.
import java.util.Scanner; // Traes la herramienta para leer el teclado.

// 2. Estructura basica
public class MiPrograma2 { // Nombre de archivo.
    public static void main(String[] args) { // El motor que arranca el programa.

// 3. CREACION DE LOS MAPAS (Tu memoria)        
        HashMap<String, Double> precios = new HashMap<>();
        // Creas un mapa donde la LLAVE es texto (nombre) y el VALOR es decimal (precio).
        HashMap<String, Integer> stock = new HashMap<>();
        // Creas un mapa donde la LLAVE es texto y el VALOR es entero (cuántos hay).

// 4. CARGA DE DATOS (Inventario)        
        precios.put("chetos", 15.50); //Registras precio.
        stock.put("chetos", 10); // Registras existencia inicial
        precios.put("refrescos", 18.50);
        stock.put("refrescos", 5);

// 5. INTERACCIÓN CON EL USUARIO
        Scanner entrada = new Scanner(System.in); // Abres el canal del teclado.
        System.out.println("¿Qué desea comprar?: ");
        String pedido = entrada.nextLine().toLowerCase(); // Lees lo que escribió, Lo haces minusculas para que coincida siempre.
       
// 6. PRIMER VALIDACIÓN: ¿Existe el producto?
        if (precios.containsKey(pedido)){ // Pregunta: "¿Tengo este nombre en mi lista de precios?"

// 7. SEGUNDA VALIDACIÓN: ¿Hay existencias?       
            int cantidadActual = stock.get(pedido);  // Buscas cuántos hay de ese producto.


            if (cantidadActual > 0) { // Si hay más de cero, podemos vender.
                System.out.println("¡Claro! El precios es: $" + precios.get(pedido));

                // 1. AVISAR AL USUARIO:
                System.out.println("¿Cuántos quieres llevar?: ");
                int unidadesPedidas = entrada.nextInt(); // Lees la cantidad deseada.

// 8. Tercera Validación: ¿Me alcanza lo que tengo?
                if (unidadesPedidas <= cantidadActual) {
                    // RESTA LAS UNIDADES PEDIDAS (No solo 1):
                    stock.put(pedido, cantidadActual - unidadesPedidas); 
                     // "Actualiza el stock con lo que había menos lo que se llevaron".

                    double total = unidadesPedidas * precios.get(pedido); // Calculo del dinero
                    System.out.println("Venta realizada. Total: $" + total);
                    System.out.println("Quedan " + stock.get(pedido) + " en stock");

// 9. MENSAJES DE ERROR Y CIERRE                    
                } else {
                    System.out.println("No tengo suficiente. Solo hay " + cantidadActual); // Si cantidadActual era 0.
                }
            } else {
                System.out.println("Lo sentimos, no hay stock de " + pedido);  // Si cantidadActual era 0.
            }
        } else {
            System.out.println("No vendemos ese producto."); // Si no estaba en el mapa.
        }
        entrada.close(); // "Cierras el teclado" para no gastar memoria.
    }

}