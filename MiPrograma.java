import java.util.HashMap;

public class MiPrograma {
    public static void main(String[] args) {
        
        // HashMap = A data structure that store key-value pairs
        //           keys are unique, but values can be duplicated
        //           Does not maintain any  order, but is memory efficient
        //           HashMap<Key, value>
        
        HashMap<String, Double> map = new HashMap<>();

        map.put("apple", 0.50);
        map.put("orange", 0.75);
        map.put("banana", 0.25);
        map.put("coconut", 1.00);

        //map.remove("apple"); //Eliminar productos

        //System.out.println(map.get("coconut")); //Dame el valor donde la clave es manzana.
        //System.out.print(map); //Imprime toda la lista
        //System.out.println(map.containsKey("apple")); // There is a banana key return it returns a boolean "True"
        //System.out.println(map.containsValue(7.00)); // existe a value 
        //System.out.println(map.size()); // to obtain a size of our map, call method map.size.

        for(String key : map.keySet()){ // Obtain all key of our map
            System.out.println(key + " : $" + map.get(key)); // Printer our key pluss add dots and one more monetary unit and use our get method to obtain each key
        }

        //if(map.containsKey("apple")){ //Our map contains an apple
            //System.out.println(map.get("apple")); //if is true, it will generate a map.get and obtain your apple

        //} each key
        //else{ // Otherwise
            //System.out.println("Key not found!"); // product not found!
        //}
    }
    
}
