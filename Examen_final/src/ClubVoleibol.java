
public class ClubVoleibol {

    private Jugador[] jugadores;
    private int totalJugadores;
    private final int MAX_JUGADORES = 30;
    private final String[] NOMBRES_MESES = {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    // Constructor
    public ClubVoleibol() {
        jugadores = new Jugador[MAX_JUGADORES];
        totalJugadores = 0;
    }

    // Método para agregar jugador
    public boolean agregarJugador(String nombre, String fechaNacimiento) {
        if (totalJugadores < MAX_JUGADORES) {
            int nuevoId = totalJugadores + 1;
            jugadores[totalJugadores] = new Jugador(nuevoId, nombre, fechaNacimiento);
            totalJugadores++;
            return true;
        }
        return false;
    }

    // Método para buscar jugador por ID
    public Jugador buscarJugador(int id) {
        for (int i = 0; i < totalJugadores; i++) {
            if (jugadores[i].getId() == id) {
                return jugadores[i];
            }
        }
        return null;
    }

    // Método para registrar pago
    public boolean registrarPago(int idJugador, int mes, double monto) {
        Jugador jugador = buscarJugador(idJugador);
        if (jugador != null && jugador.isActivo()) {
            return jugador.pagarMensualidad(mes, monto);
        }
        return false;
    }

    // Método para mostrar todos los jugadores
    public void mostrarJugadores() {
        System.out.println("=== LISTA DE JUGADORES ===");
        if (totalJugadores == 0) {
            System.out.println("No hay jugadores registrados.");
            return;
        }

        for (int i = 0; i < totalJugadores; i++) {
            if (jugadores[i].isActivo()) {
                System.out.println(jugadores[i]);
                System.out.println("Total pagado: $" + jugadores[i].calcularTotalPagado());
                System.out.println("Meses pendientes: " + jugadores[i].contarMesesPendientes());
                System.out.println("-------------------");
            }
        }
    }

    // Método para mostrar estado de pagos de un jugador
    public void mostrarEstadoPagos(int idJugador) {
        Jugador jugador = buscarJugador(idJugador);
        if (jugador == null) {
            System.out.println("Jugador no encontrado.");
            return;
        }

        System.out.println("=== ESTADO DE PAGOS ===");
        System.out.println(jugador);
        System.out.println("Detalle mensual:");

        for (int i = 1; i <= 12; i++) {
            double pago = jugador.consultarMensualidad(i);
            String estado = (pago > 0) ? "PAGADO - $" + pago : "PENDIENTE";
            System.out.println(NOMBRES_MESES[i - 1] + ": " + estado);
        }

        System.out.println("\nResumen:");
        System.out.println("Total pagado: $" + jugador.calcularTotalPagado());
        System.out.println("Meses pendientes: " + jugador.contarMesesPendientes());
    }

    // Método para calcular ingresos totales del club
    public double calcularIngresosTotales() {
        double total = 0;
        for (int i = 0; i < totalJugadores; i++) {
            if (jugadores[i].isActivo()) {
                total += jugadores[i].calcularTotalPagado();
            }
        }
        return total;
    }

    // Método para obtener total de jugadores
    public int getTotalJugadores() {
        return totalJugadores;
    }

    // Método para obtener jugadores activos
    public int getJugadoresActivos() {
        int activos = 0;
        for (int i = 0; i < totalJugadores; i++) {
            if (jugadores[i].isActivo()) {
                activos++;
            }
        }
        return activos;
    }
}
