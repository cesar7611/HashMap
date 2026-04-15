import java.util.Scanner;

public class ValidadorEdad {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("¿Cómo te llamas? ");
        String nombre = lector.nextLine();

        System.out.print("Hola " + nombre + ", ¿cuántos años tienes? ");
        int edad = lector.nextInt();

        // La decisión (if-else)
        if (edad < 18) {
            System.out.println("¡Eres menor de edad! no Puedes pasar.");
        } else if (edad == 18) {
          System.out.println("Felicidades acabas de cumplir la mayoria de edad");
        }
          else {
            System.out.print("Eres mayor de edad");
          }
            

        lector.close();
    }
}
