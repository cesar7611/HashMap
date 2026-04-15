
import javax.swing.JOptionPane;

public class CajeroVentana {
    public static void main(String[] args) {
        System.out.println("El programa ha comenzado...");
        double saldo = 1000.0;
        int opcion = 0;

        String nombre = JOptionPane.showInputDialog("Bienvenido al banco java. ¿Cual es tu nombre?");
        if (nombre == null || nombre.trim().isEmpty()) {
            nombre = "Cliente"; //por si no escribe nada
        }

        while (opcion != 3) {
            String menu = "Saldo actual: $" + saldo + "\n" +
                          "1. Depositar monedas\n" +
                          "2. Retirar dinero\n" +
                          "3. Salir\n\n" +
                          "Elija una opción:";

            String respuesta = JOptionPane.showInputDialog(null, menu, "BANCO JAVA", JOptionPane.QUESTION_MESSAGE);
            
            if (respuesta == null) break; 

            // --- RED DE SEGURIDAD PARA EL MENÚ ---
            try {
                opcion = Integer.parseInt(respuesta);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escribe un número del 1 al 3", "Error de entrada", JOptionPane.WARNING_MESSAGE);
                continue; // Regresa al inicio del while
            }

            if (opcion == 1) {
                String dep = JOptionPane.showInputDialog("¿Cuánto desea depositar?");
                if (dep == null) continue;
                
                // --- RED DE SEGURIDAD PARA EL DEPÓSITO ---
                try {
                    double deposito = Double.parseDouble(dep);
                    saldo = saldo + deposito;
                    JOptionPane.showMessageDialog(null, "¡Depósito exitoso!");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Monto inválido. Usa números.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            else if (opcion == 2) {
                String ret = JOptionPane.showInputDialog("¿Cuánto desea retirar?");
                if (ret == null) continue;

                // --- RED DE SEGURIDAD PARA EL RETIRO ---
                try {
                    double retiro = Double.parseDouble(ret);
                    if (retiro <= saldo) {
                        saldo = saldo - retiro;
                        JOptionPane.showMessageDialog(null, "Retirando $" + retiro);
                    } else {
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Monto inválido. Usa números.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Gracias por usar el banco.");
    }
}
