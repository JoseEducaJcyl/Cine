import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SalaCine sala = new SalaCine();

        // Registrar proyecciones
        Proyeccion proyeccionManiana = new ProyeccionClasica("El Padrino", 7.0);
        Proyeccion proyeccionTarde = new Proyeccion3D("Avatar", 7.0);

        System.out.println("Proyecciones registradas:");
        System.out.println("1. Mañana: " + proyeccionManiana.getTitulo());
        System.out.println("2. Tarde (3D): " + proyeccionTarde.getTitulo());

        sala.mostrarDisponibilidad();

        System.out.print("\nElige horario (1.Mañana / 2.Tarde): ");
        int opcion = sc.nextInt();

        Proyeccion seleccionada = (opcion == 1) ? proyeccionManiana : proyeccionTarde;

        System.out.print("Elige número de asiento (1-50): ");
        int asiento = sc.nextInt();

        try {
            sala.reservar(asiento);
            System.out.println("\nReserva confirmada.");
            System.out.println("Película: " + seleccionada.getTitulo());
            System.out.println("Precio final: $" + seleccionada.calcularPrecio());
        } catch (AsientoNoDisponibleException e) {
            System.out.println("\nERROR: " + e.getMessage());
        }

        sc.close();
    }
}
