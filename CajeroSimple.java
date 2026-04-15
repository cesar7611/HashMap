import java.util.Scanner;

public class CajeroSimple {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        double saldo = 1000; //Empezamos con mil pesitos
        int opcion = 0;

        System.out.print("------ BIENVENIDO AL BANCO JAVA --------");

        while (opcion != 3) {
            System.out.print("\n\n\nSaldo actual: $" + saldo);
            System.out.print(" 1.Depositar dinero " );
            System.out.print(" 2.Retirar dinero" );
            System.out.print(" 3.Salir ");
            System.out.print(" Elija una opción: ");
            opcion = lector .nextInt();

            if (opcion == 1) {
                System.out.print(" ¿Cuanto desea depositar? ");
                double deposito = lector.nextDouble();
                saldo = saldo + deposito; //actualizamos el saldo
                System.out.println("¡Deposito exitoso!");
            }
            else if (opcion ==2) {
                System.out.print(" ¿Cuanto desea retirar? ");
                double retiro = lector.nextDouble();
                if ( retiro <= saldo) {
                    saldo = saldo - retiro;
                    System.out.print("Retirando dinero...");
                } else {
                    System.out.println("Saldo insuficiente.");
                } 
            }
            else if (opcion == 3) {
                System.out.println("Gracias por usar el cajero. ¡Adiós!");
            }
            else {
                System.out.println("Opcion no valida");
            }
        }
        lector.close();
    }

    
}
