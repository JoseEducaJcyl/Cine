public abstract class Proyeccion {
    protected String titulo;
    protected double precioBase;

    public Proyeccion(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
    }

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

    public abstract double calcularPrecio();
}
