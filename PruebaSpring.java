
    public class PruebaSpring {

    // Imagina que esto es lo que pasa cuando alguien entra a "://tuweb.com"
    public String saludarUsuario(String nombre) {
        return "Hola " + nombre + ", bienvenido al Backend con Spring Boot";
    }

    // Imagina que esto pasa en "://tuweb.com"
    public String revisarServidor() {
        return "Servidor corriendo perfectamente en el puerto 8080";
    }

    public static void main(String[] args) {
        PruebaSpring miServidor = new PruebaSpring();

        // Simulamos una petición del usuario
        System.out.println(miServidor.saludarUsuario("César Esteban"));
        System.out.println(miServidor.revisarServidor());
    }
}

    

