package igualdades;

/**
 *
 * @author andresteve07
 */
public class Perro {
    private float peso;
    private int edad;

    public Perro(float peso, int edad) {
        this.peso = peso;
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!Perro.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        
        final Perro otroPerro = (Perro) obj;
        if (this.edad == otroPerro.getEdad() 
                && this.peso == otroPerro.getPeso()) {
            return true;
        } else {
            return false;
        }
    }

    
    
}
