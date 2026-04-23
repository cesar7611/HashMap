import java.util.HashMap;
import java.util.Map;

public class ContadorFrutas {
    public static void main(String[] args) {
        String[] canasta = {"manzana", "pera", "manzana", "naranja", "pera", "manzana"};
        
        //El mapa será <Nombre de la fruta Cuántas van>
        Map<String, Integer> conteo = new HashMap<>();

        for(String fruta : canasta) {
            if (conteo.containsKey(fruta)) {
                // Si la fruta ya esta en el mapa, le sumamos un valor al que ya tenia
                conteo.put(fruta, conteo.get(fruta) + 1);
            } else {
                //Si es la PRIMERA VEZ que vemos la fruta, La anotamos con un 1
                conteo.put(fruta, 1);
            }
        }

        System.out.println(conteo);
        // Resultado: {manzana=3, pera=2, naranja=1}
    }
}