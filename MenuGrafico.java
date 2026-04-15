import javax.swing.JOptionPane;

public class MenuGrafico {
    public static void main(String[] args) {
        int opcion = 0;
        double saldo = 5000; //Saldo simulado

        String menu = "--- MENU USUARIO ---\n" +
                       "1. Saludar\n" +
                       "2. Ver saldo\n" +
                       "3. Retirar dinero\n" +
                       "4. Salir\n" +
                       "Selecciona una opcion:";
        do {
            try {
                //Mostramos el menu y recibimos la entrada del usuario
                String entrada = JOptionPane.showInputDialog(null, menu, "Menu de opciones", JOptionPane.QUESTION_MESSAGE);

                //Si el usuario preciona "Cancelar o cierra la ventana"
                if ( entrada == null) break;
                
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1 :
                        JOptionPane.showConfirmDialog(null, "¡Hola! Espero que tengas un gran dia.", "Saludos", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 2 :
                        JOptionPane.showConfirmDialog(null, "Tu saldo actual es: $" + saldo, "Consulta de saldo" , JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3 :
                         String montoStr = JOptionPane.showInputDialog(null, "¿Cuanto deseas retirar?");
                        if (montoStr != null) {
                            double retiro = Double.parseDouble(montoStr);
                            if ( retiro > 0 && retiro <= saldo) {
                                saldo -= retiro; // Restamos el saldo
                                JOptionPane.showMessageDialog(null, "Retiro exitoso. Nuevo saldo: $" + saldo);
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "Fondos insuficientes o monto invalido.", "Error", 0);
                            }
                            
                        }
                    break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Gracias por usar el sistema. ¡Adios!", "Salida", 1);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida.", "Error", 0);
        }              

    
    }  catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Por favor ingresa un valor numeroco valido.", "Error de formato", 0);
    }
        } while (opcion != 4);
            
        }
}

