import javax.swing.*;
import java.nio.file.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BancoPersistente {
    private static final String ARCHIVO_SALDO = "saldo.txt";
    private static final String ARCHIVO_LOG = "historial.txt";
    private static final String ARCHIVO_PIN = "pin.txt"; // Nuevo archivo para la clave

    public static void main(String[] args) {
        // --- SISTEMA DE SEGURIDAD AL INICIO ---
        if (!verificarAcceso()) {
            JOptionPane.showMessageDialog(null, "Acceso denegado. Saliendo...");
            return; 
        }

        double saldo = cargarSaldo();
        int opcion = 0;

        do {
            String menu = "--- BANCO DIGITAL ---\n" +
                          "Saldo actual: $" + String.format("%.2f", saldo) + "\n\n" +
                          "1. Ver Historial\n" +
                          "2. Retirar dinero\n" +
                          "3. Depositar dinero\n" +
                          "4. Cambiar PIN\n" + // Opción extra de seguridad
                          "5. Salir\n\n" +
                          "Selecciona una opción:";

            try {
                String entrada = JOptionPane.showInputDialog(null, menu, "Cajero Seguro", JOptionPane.PLAIN_MESSAGE);
                if (entrada == null) break;
                opcion = Integer.parseInt(entrada);

                switch (opcion) {
                    case 1:
                        JOptionPane.showMessageDialog(null, "Historial:\n" + cargarHistorial());
                        break;
                    case 2:
                        double retiro = pedirMonto("¿Cuánto deseas retirar?");
                        if (retiro > 0 && retiro <= saldo) {
                            saldo -= retiro;
                            guardarSaldo(saldo);
                            registrarMovimiento("RETIRO", retiro);
                            JOptionPane.showMessageDialog(null, "Retiro exitoso.");
                        }
                        break;
                    case 3:
                        double deposito = pedirMonto("¿Cuánto deseas depositar?");
                        if (deposito > 0) {
                            saldo += deposito;
                            guardarSaldo(saldo);
                            registrarMovimiento("DEPOSITO", deposito);
                            JOptionPane.showMessageDialog(null, "Depósito exitoso.");
                        }
                        break;
                    case 4:
                        crearNuevoPin();
                        break;
                }
            } catch (Exception e) {
                opcion = 0;
            }
        } while (opcion != 5);
    }

    // --- LÓGICA DE SEGURIDAD (PIN) ---

    private static boolean verificarAcceso() {
        try {
            // Si no hay PIN guardado, obligamos a crear uno
            if (!Files.exists(Paths.get(ARCHIVO_PIN))) {
                JOptionPane.showMessageDialog(null, "Bienvenido. Por favor, crea un PIN de seguridad.");
                crearNuevoPin();
                return true;
            }

            // Si ya existe, pedimos que lo ingrese (máximo 3 intentos)
            String pinGuardado = Files.readString(Paths.get(ARCHIVO_PIN)).trim();
            for (int i = 3; i > 0; i--) {
                String intento = JOptionPane.showInputDialog("Ingresa tu PIN (" + i + " intentos restantes):");
                if (intento != null && intento.equals(pinGuardado)) return true;
                if (intento == null) break;
                JOptionPane.showMessageDialog(null, "PIN incorrecto.");
            }
        } catch (IOException e) {
            System.out.println("Error de seguridad.");
        }
        return false;
    }

    private static void crearNuevoPin() {
        String nuevoPin = JOptionPane.showInputDialog("Ingresa tu nuevo PIN numérico:");
        if (nuevoPin != null && !nuevoPin.isEmpty()) {
            try {
                Files.writeString(Paths.get(ARCHIVO_PIN), nuevoPin);
                JOptionPane.showMessageDialog(null, "PIN actualizado con éxito.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se pudo guardar el PIN.");
            }
        }
    }

    // --- MÉTODOS DE APOYO (REUTILIZADOS) ---

    private static double pedirMonto(String mensaje) {
        String entrada = JOptionPane.showInputDialog(mensaje);
        try { return Double.parseDouble(entrada); } catch (Exception e) { return -1; }
    }

    private static void registrarMovimiento(String tipo, double monto) {
        String linea = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")) + 
                       " | " + tipo + ": $" + monto + "\n";
        try { Files.writeString(Paths.get(ARCHIVO_LOG), linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND); }
        catch (IOException e) { }
    }

    private static String cargarHistorial() {
        try { return Files.exists(Paths.get(ARCHIVO_LOG)) ? Files.readString(Paths.get(ARCHIVO_LOG)) : "Sin movimientos."; }
        catch (IOException e) { return "Error al leer historial."; }
    }

    private static double cargarSaldo() {
        try { return Files.exists(Paths.get(ARCHIVO_SALDO)) ? Double.parseDouble(Files.readString(Paths.get(ARCHIVO_SALDO)).trim()) : 5000.0; }
        catch (Exception e) { return 5000.0; }
    }

    private static void guardarSaldo(double saldo) {
        try { Files.writeString(Paths.get(ARCHIVO_SALDO), String.valueOf(saldo)); }
        catch (IOException e) { }
    }
}

