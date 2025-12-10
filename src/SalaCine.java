public class SalaCine {
    private boolean[] asientos = new boolean[50];

    public SalaCine() {
        // por defecto todos libres (false = libre)
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = false;
        }
    }

    public void reservar(int numeroAsiento) throws AsientoNoDisponibleException {
        if (numeroAsiento < 1 || numeroAsiento > 50) {
            throw new AsientoNoDisponibleException("Número de asiento inválido.");
        }

        if (asientos[numeroAsiento - 1]) {
            throw new AsientoNoDisponibleException("El asiento ya está ocupado.");
        }

        asientos[numeroAsiento - 1] = true;
    }

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
