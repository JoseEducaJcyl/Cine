//Clase abstracta Proyeccion con los atributos
//(String) titulo y (double) precioBase
public abstract class Proyeccion {
    protected String titulo;
    protected double precioBase;

    //Constructor
    public Proyeccion(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

    //Setters y Getters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    //Metodo abstracto sin definir calcularPrecio
    public abstract double calcularPrecio();
}
