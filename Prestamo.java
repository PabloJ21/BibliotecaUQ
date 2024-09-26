import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Prestamo {
    private String codigo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private double costo;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private Collection<DetallePrestamo> detallePrestamos;

    public Prestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario) {
        this.codigo = codigo;
        this.fechaPrestamo = LocalDate.now();
        this.fechaEntrega = LocalDate.now();
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
        this.detallePrestamos = new LinkedList<>();

    }

    public void adicionarLibro(Libro libro) {
        if (libro.isDisponible()) {
            libros.add(libro);
            libro.actualizarUnidades(-1);
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    public long calcularDiasPrestamo() {
        int dias = 0;
        LocalDate inicio = fechaPrestamo;
        LocalDate fin = fechaEntrega;

        while (!inicio.isEqual(fin)) {
            dias++;
            inicio = inicio.plusDays(1); 
        }

        return dias;
    }

    public double calcularCosto() {
        long dias = calcularDiasPrestamo();
        double costoPorDia = 5.0;
        return dias * costoPorDia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Collection<DetallePrestamo> getDetallePrestamos() {
        return detallePrestamos;
    }

    public void setDetallePrestamos(Collection<DetallePrestamo> detallePrestamos) {
        this.detallePrestamos = detallePrestamos;
    }

    @Override
    public String toString() {
        return "Prestamo [codigo=" + codigo + ", fechaPrestamo=" + fechaPrestamo + ", fechaEntrega=" + fechaEntrega
                + ", costo=" + costo + ", estudiante=" + estudiante + ", bibliotecario=" + bibliotecario
                + ", detallePrestamos=" + detallePrestamos + "]";
    }

}
