import java.util.Scanner;
//Clase Main con el metodo main para ejercutar el codigo
public class Main {
    public static void main(String[] args) {
        //Declaracion de un objeto Scanner, como sc
        Scanner sc = new Scanner(System.in);

        //Declaracion un objeto SalaCine, como sala
        SalaCine sala = new SalaCine();

        //Declaracion de dos objtos Proyeccion, proyeccionManiana y proyeccionTarde
        Proyeccion proyeccionManiana = new ProyeccionClasica("El Padrino", 7.0);
        Proyeccion proyeccionTarde = new Proyeccion3D("Avatar", 7.0);

        //Muestra el titulo de las proyecciones
        System.out.println("Proyecciones registradas:");
        System.out.println("1. Mañana: " + proyeccionManiana.getTitulo());
        System.out.println("2. Tarde (3D): " + proyeccionTarde.getTitulo());

        //Menu que sirve para ver la disponibilidad, elegir una proyeccion
        //y motrar la sala de cine
        System.out.println("-----MENÚ-----");
        System.out.println(" 1----- Mostrar disponibiliodad");
        System.out.println(" 2----- Elegir proyeccion");
        System.out.println(" 3----- Mostrar sala de cine");
        System.out.println(" SALIR (Cualquier tecla)");
        System.out.println("Escriba la opcion: ");
        int opcionMenu = sc.nextInt();
        boolean bandera = false;

        //Bucle while para que el usuario pueda navegar a traves del menu (con fallos)
        while (!bandera) {
            switch (opcionMenu) {
                //Muestra la disponibilidad de la sala
                case 1:
                    sala.mostrarDisponibilidad();
                    System.out.println("Escriba la opcion: ");
                    sc.nextInt();
                    sc.nextLine();

                //Elegir una proyeccion entre mañana y tarde
                case 2:
                    boolean continuar = true;
                    Proyeccion seleccionadaManiana = null;
                    Proyeccion seleccionadaNoche  = null;

                    System.out.print("\nElige horario (1.Mañana / 2.Tarde): ");
                    int opcion = sc.nextInt();

                    //Bucle para que el usuario pueda elegir varios asientos, y termine
                    //si elegio uno ocupado, diferenciando si elgio mañana o tarde
                    while (continuar) {
                        switch (opcion) {
                            case 1:
                                seleccionadaManiana = proyeccionManiana;
                                break;
                            case 2:
                                seleccionadaNoche = proyeccionTarde;
                                break;
                            default:
                                System.out.println("Valor incorrecto. " + opcion);
                                System.out.print("\nElige horario (1.Mañana / 2.Tarde): ");
                                opcion = sc.nextInt();
                                sc.nextLine();
                        }

                        System.out.print("Elige número de asiento (1-50): ");
                        int asiento = sc.nextInt();

                        //Muestra la reserva y su precio
                        if (seleccionadaManiana != null) {
                            try {
                                sala.reservar(asiento);
                                System.out.println("\nReserva confirmada.");
                                System.out.println("Película: " + seleccionadaManiana.getTitulo());
                                System.out.println("Precio final: $" + seleccionadaManiana.calcularPrecio());
                            } catch (AsientoNoDisponibleException e) {
                                System.out.println("\nERROR: " + e.getMessage());
                                System.out.println("Escriba la opcion: ");
                                sc.nextInt();
                                sc.nextLine();
                                continuar = false;
                            }
                        }else if (seleccionadaNoche != null) {
                            try {
                                sala.reservar(asiento);
                                System.out.println("\nReserva confirmada.");
                                System.out.println("Película: " + seleccionadaNoche.getTitulo());
                                System.out.println("Precio final: $" + seleccionadaNoche.calcularPrecio());
                            } catch (AsientoNoDisponibleException e) {
                                System.out.println("\nERROR: " + e.getMessage());
                                System.out.println("Escriba la opcion: ");
                                sc.nextInt();
                                sc.nextLine();
                                continuar = false;
                            }
                        }

                    }
                //Muestra la sala de cine
                case 3:
                    sala.motrarSalaCine();
                    System.out.println(" ");
                    System.out.println("Escriba la opcion: ");
                    sc.nextInt();
                    sc.nextLine();

                //Si el usuario escribe cualquier tecla que no aparece en el menu
                //sale del programa
                default:
                    System.out.println("Saliendo....");
                    bandera = true;
            }
        }


        sc.close();
    }
}
