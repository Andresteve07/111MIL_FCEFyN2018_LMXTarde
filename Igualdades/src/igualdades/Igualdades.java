package igualdades;

/**
 *
 * @author andresteve07
 */
public class Igualdades {

    public static void main(String[] args) {
        Perro canino1 = new Perro(13.4f, 10);
        Perro canino2 = new Perro(8.3f, 4);
        Perro canino3 = new Perro(13.4f, 10);
        
        Perro referenciaAlCanino1;    //Referencia a un objeto de tipo Perro.
	referenciaAlCanino1 = canino1;//hace referencia al "canino1".
	
        //Cuantos objetos tipo Perro existen en la memoria?
        
	System.out.println(canino1 == canino2);//false
	System.out.println(canino1 == canino3);//false
	System.out.println(canino1 == referenciaAlCanino1);//true
        System.out.println(canino1.equals(canino3));//true: sólo funciona si la clase Perro sobreescribe el metodo equals correctamente.
    }
    
}
