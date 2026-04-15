import java.util.Scanner;

public class PreguntonMejorado {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        String nombre = "";

        //El bucle se repite mientras el nombre esa vacio
        while (nombre.trim().isEmpty()) {
            System.out.print("¿Como te llamas?");
            nombre = lector.nextLine();

            if (nombre.trim().isEmpty()){
                System.out.print("¡Error! El nombre no puede estar vacio.");
            }
            
        }
        
        System.out.println("¡Hola " + nombre + "!");
        
        lector.close();
    }
}
