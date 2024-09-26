import java.time.LocalDate;
import java.util.Collection;

public class Bibliotecario extends Persona {

    private double salario;
    private int añosAntiguedad;
    private Collection<Prestamo> prestamos;

    public Bibliotecario(String nombre, String cedula, String correo, int telefono, double salario, int añosAntiguedad) {
        super(nombre, cedula, correo, telefono);
        this.salario = salario;
        this.añosAntiguedad = añosAntiguedad;
    }

    public double calcularSalarioConBonificacion(double totalPrestamos) {
        double salarioBase = salario + (totalPrestamos * 0.2);
        double bonificacion = salarioBase * (0.02 * añosAntiguedad);
        return salarioBase + bonificacion;
    }

    public void entregarPrestamo(Prestamo prestamo) {
        prestamo.setFechaEntrega(LocalDate.now());
        double costo = prestamo.calcularCosto();
        for (Libro libro : prestamo.getLibros()) {
            libro.actualizarUnidades(1); 
        }
        System.out.println("El costo del préstamo es: " + costo);
    }

    // Getters - Setters//

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAñosAntiguedad() {
        return añosAntiguedad;
    }

    public void setAñosAntiguedad(int añosAntiguedad) {
        this.añosAntiguedad = añosAntiguedad;
    }

    public Collection<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(Collection<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    @Override
    public String toString() {
        return "Bibliotecario [salario=" + salario + ", añosAntiguedad=" + añosAntiguedad + ", prestamos=" + prestamos
                + "]";
    }

}
