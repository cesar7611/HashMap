import java.util.HashMap;
import java.util.Scanner;


public class LoginUHRS {
    public static void main(String[] args) {
        //1. Base de datos evaluadores.
        HashMap<String, String> evaluadores = new HashMap<>();

        evaluadores.put("teniente", "50kultra");
        evaluadores.put("sargentoIA", "uhr_v5.3");
        evaluadores.put("novato", "12345");

        //2. pedir datos.
        Scanner teclado = new Scanner(System.in);
        System.out.print("Usuario UHRS: ");
        String user = teclado.nextLine();
        System.out.print("Password: ");
        String pass = teclado.nextLine();

        //3. Verificar login
        if(evaluadores.containsKey(user)){
        String passCorrecto = evaluadores.get(user);
        if(passCorrecto.equals(pass)){
            System.out.println("Acceso concedido. Bienvenido " + user );
        } else {
            System.out.println("Usuario incorrecto. Intenta de nuevo.");
        }
    } else {
        System.out.println("Usuario no existe. Registrate en Clickworker");
    }
  }
}
