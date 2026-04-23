class Libro {
    String titulo;
    String autor;
    double precioRenta;
    boolean prestado;
    

    // Constructor
    public Libro(String titulo, String autor, double precioRenta) {
        this.titulo = titulo;
        this.autor = autor;
        this.precioRenta = precioRenta;
        this.prestado = false;
    }

    // El método robusto que muestra la información automaticamente
    @Override
    public String toString() {
        return "Libro: " + titulo + " | Autor: " + autor + " | costo: $" + precioRenta + " | Estado: " + (prestado ? "Prestado" : "Disponible");
    }

    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println(">>> Has rentado: " + titulo + "' por $" + precioRenta);
        } else {
            System.out.println(">>> ERROR '" + titulo + " ya esta rentado.");
        }
    }

    public void devolver() {
        prestado = false;
        System.out.println("Has devuelto: " + titulo);
    }

    public static void main(String[] args) {
        // 1. Creamos los objetos libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabo", 25.50);
        Libro libro2 = new Libro("Don Quijote", "Cervantes", 15.00);

        // 2. Mostramos estado inicial (Usa el toString automáticamente)    
        System.out.println("--- Estado inicial ---");
        System.out.println(libro1);
        System.out.println(libro2);

        // 3. Hacemos movimientos 
        System.out.println("\n--- Proceso en Renta ---");
        libro1.prestar(); 
        

        // 4. Mostramos como quedaron (Libro1 cambió, libro2 no)
        System.out.println("--- Estado actual ---");
        System.out.println(libro1);
        System.out.println(libro2);
    }
}
