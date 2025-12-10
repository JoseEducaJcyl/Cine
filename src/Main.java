import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SalaCine sala = new SalaCine();

        Proyeccion proyeccionManiana = new ProyeccionClasica("El Padrino", 7.0);
        Proyeccion proyeccionTarde = new Proyeccion3D("Avatar", 7.0);

        System.out.println("Proyecciones registradas:");
        System.out.println("1. Mañana: " + proyeccionManiana.getTitulo());
        System.out.println("2. Tarde (3D): " + proyeccionTarde.getTitulo());

        sala.mostrarDisponibilidad();

        boolean continuar = true;
        Proyeccion seleccionada = null;

        System.out.print("\nElige horario (1.Mañana / 2.Tarde): ");
        int opcion = sc.nextInt();

        while(continuar){
            switch (opcion){
                case 1:
                    seleccionada = proyeccionManiana;
                    break;
                case 2:
                    seleccionada = proyeccionTarde;
                    break;
                default:
                    System.out.println("Valor incorrecto. " + opcion);
                    System.out.print("\nElige horario (1.Mañana / 2.Tarde): ");
                    opcion = sc.nextInt();
            }

            System.out.print("Elige número de asiento (1-50): ");
            int asiento = sc.nextInt();

            try {
                sala.reservar(asiento);
                System.out.println("\nReserva confirmada.");
                System.out.println("Película: " + seleccionada.getTitulo());
                System.out.println("Precio final: $" + seleccionada.calcularPrecio());
            } catch (AsientoNoDisponibleException e) {
                System.out.println("\nERROR: " + e.getMessage());
                continuar = false;
            }
        }
        sala.motrarSalaCine();

        sc.close();
    }
}
