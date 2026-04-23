public class CicloDos {
    public static void main(String[] args) {
        int i = 1, j = 99; //Declaramos nuestras dos variables i empieza en la base (1) y j empieza en lo alto (99)

        System.out.println("Series con for: ");
        for (i = 1; i <= 5; i++){ //Este ciclo va a dar 5 vueltas exactamente, en cada vuelta, a i se le suma 1.
            if(i < 5){ //Mientras no estemos en la ultima vuelta.
                System.out.print(i + ", "); // Imprime el valor de i y una coma.
                System.out.print(j + ", "); // Imprime el valor de j y una coma.
            } else { //¡Llegamos a la ultima vuelta cuando (i es 5)!
                System.out.print(i + ", "); //imprime el 5 y una coma
                System.out.print(j);//imprime el valor de j sin coma para que la cierre limpia.
            }
            j--; //Esta es la clave. Mientras el for sube a i automáticamente, tú manualmente le restas 1 a j en cada vuelta. Así, cuando i es 2, j ya bajó a 98.            
        }
        System.out.println("");
        
        i = 1;
        j = 99;

         System.out.println("Series con while: ");
        while (i <= 5) {
            if (i < 5) {  
                System.out.print(i + ", " + ", "); 
            } else {
               System.out.print(i + ", " + j); 
            }
            i ++;
            j--; 
    }

      System.out.println("");
        
        i = 1;
        j = 99;

        
         System.out.println("Series con do-while: ");
         do{
            if(i < 5){ //Mientras no estemos en la ultima vuelta.
                System.out.print(i + ", "); // Imprime el valor de i y una coma.
                System.out.print(j + ", "); // Imprime el valor de j y una coma.
            } else { //¡Llegamos a la ultima vuelta cuando (i es 5)!
                System.out.print(i + ", "); //imprime el 5 y una coma
                System.out.print(j);//imprime el valor de j sin coma para que la cierre limpia.
            }
            i ++;
            j--; 

         } while (i <= 5);
}
}