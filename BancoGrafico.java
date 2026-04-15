import javax.swing.*;
import java.awt.*;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.StandardOpenOption;

public class BancoGrafico extends JFrame {
    private double saldo;
    private JLabel IblSaldo;
    private static final String ARCHIVO_SALDO = "saldo.txt";

    public BancoGrafico() {
        // 1. Cargar el saldo al iniciar
        saldo = cargarSaldo();

        // Configuracion de la ventana
        setTitle("Banco Digital Pro");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Panel superior: El Saldo
        IblSaldo = new JLabel("$" + String.format("%.2f", saldo), SwingConstants.CENTER);
        IblSaldo.setFont(new Font("Monospaced", Font.BOLD, 50));
        IblSaldo.setForeground(new Color(46, 139, 87));
        IblSaldo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(IblSaldo, BorderLayout.NORTH);

        // Panel central: Botones
        JPanel panelBotones = new JPanel(new GridLayout(2, 2, 15, 15));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 30));

        JButton btnDepositar = new JButton("DEPOSITAR");
        btnDepositar.setBackground(new Color(173, 255, 47));
        
        JButton btnRetirar = new JButton("RETIRAR");
        btnRetirar.setBackground(new Color(255, 99, 71));

        JButton btnHistorial = new JButton("HISTORIAL");
        btnHistorial.setBackground(Color.CYAN);

        JButton btnSalir = new JButton("SALIR");
        btnSalir.setBackground(Color.ORANGE);
        
        panelBotones.add(btnDepositar);
        panelBotones.add(btnRetirar);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        // --- ACCIONES ----

        btnDepositar.addActionListener(e -> {
            String monto = JOptionPane.showInputDialog("¿Cuanto vas a depositar?");
            if (monto != null && !monto.isEmpty()) {
                try {
                    saldo += Double.parseDouble(monto);
                    actualizarBanco();
                    registrarMovimiento("DEPOSITO", Double.parseDouble(monto));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa un numero valido.");
                }
            }
        });

        btnRetirar.addActionListener(e -> {
            String monto = JOptionPane.showInputDialog("¿Cuanto vas a retirar?");
            if (monto != null && !monto.isEmpty()) {
                try {
                    double m = Double.parseDouble(monto);
                    if (m <= saldo) {
                        saldo -= m;
                        actualizarBanco();
                        registrarMovimiento("RETIRO", m); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Monto inválido.");
                }
            }
        });

        // --- AQUÍ ESTÁ LA CORRECCIÓN DEL HISTORIAL ---
        btnHistorial.addActionListener(e -> {
            String datos = cargarHistorial();
            JFrame ventanaLog = new JFrame("Historial");
            ventanaLog.setSize(300, 400);
            ventanaLog.setLocationRelativeTo(this);
            JTextArea area = new JTextArea(datos);
            area.setEditable(false);
            ventanaLog.add(new JScrollPane(area));
            ventanaLog.setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));
    } // AQUÍ CIERRA EL CONSTRUCTOR

    // --- MÉTODOS DE APOYO ---

    private void actualizarBanco() {
        IblSaldo.setText("$" + String.format("%.2f", saldo));
        guardarSaldo(saldo);
    }

    private double cargarSaldo() {
        try {
            if (Files.exists(Paths.get(ARCHIVO_SALDO))) {
                String contenido = Files.readString(Paths.get(ARCHIVO_SALDO));
                return Double.parseDouble(contenido.trim());
            }
        } catch (Exception e) {
            System.out.println("Error al cargar saldo.");
        }
        return 5000.0;
    }

    private void guardarSaldo(double s) {
        try {
            Files.writeString(Paths.get(ARCHIVO_SALDO), String.valueOf(s));
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo");
        }
    }

    private String cargarHistorial() {
        try {
            Path ruta = Paths.get("historial.txt");
            if (Files.exists(ruta)) {
                return Files.readString(ruta);
            }
        } catch (IOException e) {
            return "Error al leer el historial.";
        }
        return "No hay movimientos registrados.";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BancoGrafico().setVisible(true));
    }


private void registrarMovimiento(String tipo, double monto) {
    String linea = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM HH:mm")) 
                   + " | " + tipo + ": $" + monto + "\n";
    try {
        Files.writeString(Paths.get("historial.txt"), linea, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    } catch (IOException e) {
        System.out.println("No se pudo escribir en el historial.");
    }
}

}



