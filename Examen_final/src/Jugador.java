
public class Jugador extends Persona {

    private int id;
    private boolean activo;
    private double[] mensualidades;

    // Constructor
    public Jugador(int id, String nombre, String fechaNacimiento) {
        super(nombre, fechaNacimiento);
        this.id = id;
        this.activo = true;
        this.mensualidades = new double[12];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Método para pagar mensualidad de un mes específico
    public boolean pagarMensualidad(int mes, double monto) {
        if (mes >= 1 && mes <= 12 && monto > 0) {
            mensualidades[mes - 1] = monto;
            return true;
        }
        return false;
    }

     // Consulta el monto de la mensualidad de un mes específico.
    public double consultarMensualidad(int mes) {
        if (mes >= 1 && mes <= 12) {
            return mensualidades[mes - 1];
        }
        return 0;
    }

    public double calcularTotalPagado() {
        double total = 0;
        for (int i = 0; i < mensualidades.length; i++) {
            total += mensualidades[i];
        }
        return total;
    }

    // Método para contar meses sin pagar
    public int contarMesesPendientes() {
        int pendientes = 0;
        for (int i = 0; i < mensualidades.length; i++) {
            if (mensualidades[i] == 0) {
                pendientes++;
            }
        }
        return pendientes;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + super.toString() + " | Activo: " + (activo ? "Sí" : "No");
    }
}
