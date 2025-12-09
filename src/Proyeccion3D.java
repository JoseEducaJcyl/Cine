public class Proyeccion3D extends Proyeccion {
    private double recargo = 2.5;
    public Proyeccion3D(String titulo, double precioBase) {
        super(titulo, precioBase);
    }

    @Override
    public double calcularPrecio() {
        return precioBase + recargo;
    }
}
