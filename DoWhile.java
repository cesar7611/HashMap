
//Realizar un programa que imprima en pantalla la siguiente serie numerica:
// 1000, 800, 600, 200, 0,

public class DoWhile {
    public static void main(String[] args) {

        int i = 1000; //Antes de comenzar el ciclo, crea una caja llamada i y guarda el numero 1000

        do{ //¡Hazlo!
            System.out.print(i); //Imprimimos el numero actual de 0

            if (i > 0) { 
                System.out.print(", "); //Solo ponemos coma si no es el cero
            }

            i -= 200;
        
        } while (i >= 0); //¿Sigo?
        
    }
    
}
