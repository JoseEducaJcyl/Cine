//Clase SalaCine con el atributo
//(array boolean) asientos
public class SalaCine {
    private boolean[] asientos = new boolean[50];

    //Constructor
    public SalaCine() {
        //Por defecto todos libres (false = libre)
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = false;
        }
    }

    //Metodo reservar que convierte un atributo false a true, indicando que
    //se a hecho una reserva de un asiento
    public void reservar(int numeroAsiento) throws AsientoNoDisponibleException {
        if (numeroAsiento < 1 || numeroAsiento > 50) {
            throw new AsientoNoDisponibleException("Número de asiento inválido.");
        }

        if (asientos[numeroAsiento - 1]) {
            throw new AsientoNoDisponibleException("El asiento ya está ocupado.");
        }

        asientos[numeroAsiento - 1] = true;
    }

    //Metodo mostrarDisponibilidad para mostrar la disponibilidad de la sala
    public void mostrarDisponibilidad() {
        System.out.println("Disponibilidad de Asientos");
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i]) {
                System.out.println("Asiento Ocupado.");
            }else{
                System.out.println("Asiento Libre.");
            }
        }
    }

    //Metodo mostrarSalaCine para mostrar la sala de cine
    public void motrarSalaCine() {
        for (int i = 0; i < asientos.length; i++) {
            if (asientos[i]) {
                System.out.print("[*]");
            }else {
                System.out.print("[O]");
            }
        }
    }
}
