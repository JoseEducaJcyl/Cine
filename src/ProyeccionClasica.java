//Clase ProyeccionClasica que se extiende de la clase Proyeccion
public class ProyeccionClasica extends Proyeccion{

    //Constructor heredado
    public ProyeccionClasica(String titulo, double precioBase) {
        super(titulo, precioBase);
    }

    //Metodo calcularPrecio definido
    @Override
    public double calcularPrecio() {
        return precioBase;
    }
}
