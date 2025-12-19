//Clase Proyeccion3D que se extiende de la clase Proyeccion
//con el atributo (double) recargo
public class Proyeccion3D extends Proyeccion {
    private double recargo = 2.5;

    //Constructor heredado
    public Proyeccion3D(String titulo, double precioBase) {
        super(titulo, precioBase);
    }

    //Metodo calcularPrecio definido que se le suma el recargo
    @Override
    public double calcularPrecio() {
        return precioBase + recargo;
    }
}
