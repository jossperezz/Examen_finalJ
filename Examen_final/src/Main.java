
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static ClubVoleibol club = new ClubVoleibol();

    public static void main(String[] args) {
        inicializarDatos();

        System.out.println("=== SISTEMA DE CONTROL CVO ===");
        System.out.println("Club de Voleibol Ocaña");

        int opcion;
        do {
            mostrarMenu();
            opcion = evitarErrorOpcion();

            switch (opcion) {
                case 1:
                    registrarJugador();
                    break;
                case 2:
                    registrarPago();
                    break;
                case 3:
                    consultarEstadoPagos();
                    break;
                case 4:
                    club.mostrarJugadores();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 0:
                    System.out.println("¡Gracias por usar el sistema CVO!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            if (opcion != 0) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("" + "=".repeat(40));
        System.out.println("         MENÚ PRINCIPAL");
        System.out.println("=".repeat(40));
        System.out.println("1. Registrar nuevo jugador");
        System.out.println("2. Registrar pago mensualidad");
        System.out.println("3. Consultar estado de pagos");
        System.out.println("4. Ver todos los jugadores");
        System.out.println("5. Estadísticas del club");
        System.out.println("0. Salir");
        System.out.println("=".repeat(40));
        System.out.print("Seleccione opción: ");
    }

    private static int evitarErrorOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double evitarErrorPagos() {
        try {
            return Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void registrarJugador() {
        System.out.println("=== REGISTRAR JUGADOR ===");

        try {
            System.out.print("Nombre completo: ");
            String nombre = scanner.nextLine();
            if (nombre.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío");
            }

            String fechaNacimiento;
            do {
                System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
                fechaNacimiento = scanner.nextLine();
                if (fechaNacimiento.trim().isEmpty()) {
                    System.out.println("Error: La fecha no puede estar vacía.");
                } else {
                    String[] valores = fechaNacimiento.split("/");
                    if (valores.length != 3 || !valores[0].matches("\\d+") || !valores[1].matches("\\d+") || !valores[2].matches("\\d+")) {
                        System.out.println("Error: La fecha debe tener el formato dd/mm/aaaa y contener solo números.");
                        fechaNacimiento = "";
                    }
                }
            } while (fechaNacimiento.trim().isEmpty());

            if (club.agregarJugador(nombre, fechaNacimiento)) {
                System.out.println("¡Jugador registrado exitosamente!");
            } else {
                System.out.println("Error: Cupo máximo alcanzado.");
            }
            System.out.print("Tu id es: " + club.getTotalJugadores());

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método para registrar pago
    private static void registrarPago() {
        System.out.println("=== REGISTRAR PAGO ===");

        try {
            System.out.print("ID del jugador: ");
            int id = evitarErrorOpcion();
            if (id <= 0) {
                throw new IllegalArgumentException("ID debe ser un número válido");
            }

            System.out.print("Mes (1-12): ");
            int mes = evitarErrorOpcion();
            if (mes < 1 || mes > 12) {
                throw new IllegalArgumentException("Mes debe estar entre 1 y 12");
            }

            System.out.print("Monto: $");
            double monto = evitarErrorPagos();
            if (monto <= 0) {
                throw new IllegalArgumentException("Monto debe ser mayor que cero");
            }

            if (club.registrarPago(id, mes, monto)) {
                System.out.println("¡Pago registrado exitosamente!");
            } else {
                System.out.println("Error: Jugador no encontrado o inactivo.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para consultar estado de pagos
    private static void consultarEstadoPagos() {
        System.out.println("=== CONSULTAR PAGOS ===");

        try {
            System.out.print("ID del jugador: ");
            int id = evitarErrorOpcion();
            if (id <= 0) {
                throw new IllegalArgumentException("ID debe ser un número válido");
            }

            club.mostrarEstadoPagos(id);

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Método para mostrar estadísticas
    private static void mostrarEstadisticas() {
        System.out.println("=== ESTADÍSTICAS DEL CLUB ===");
        System.out.println("Total jugadores: " + club.getTotalJugadores());
        System.out.println("Jugadores activos: " + club.getJugadoresActivos());
        System.out.println("Ingresos totales: $" + club.calcularIngresosTotales());
    }

    private static void inicializarDatos() {

    }
}
