import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private String ubicacion;
    private int cantidadLibros;
    private double ganancia;
    private List<Bibliotecario> bibliotecarios;
    private List<Estudiante> estudiantes;
    private List<Libro> libros;
    private List<Prestamo> prestamos;

    public Biblioteca(String nombre, String ubicacion, double ganancia, int cantidadLibros) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.ganancia = ganancia;
        this.cantidadLibros = cantidadLibros;
        this.cantidadLibros = 0;
        this.bibliotecarios = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCantidadLibros() {
        return cantidadLibros;
    }

    public void setCantidadLibros(int cantidadLibros) {
        this.cantidadLibros = cantidadLibros;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    @Override
    public String toString() {
        return "Biblioteca [nombre=" + nombre + ", ubicacion=" + ubicacion + ", cantidadLibros=" + cantidadLibros + ", ganancia=" + ganancia + ", bibliotecarios=" + bibliotecarios + ", estudiantes=" + estudiantes + ", libros=" + libros + ", prestamos=" + prestamos + "]";
    }

    public void crearBibliotecario(String nombre, String cedula, String correo, int telefono, double salario, int añosAntiguedad) {
        Bibliotecario bibliotecario = new Bibliotecario(nombre, cedula, correo, telefono, salario, añosAntiguedad);
        bibliotecarios.add(bibliotecario);
    }

    public void crearEstudiante(String nombre, String cedula, String correo, int telefono, int edad) {
        Estudiante estudiante = new Estudiante(nombre, cedula, correo, telefono, edad);
        estudiantes.add(estudiante);
    }

    public void crearLibro(String codigo, String isbn, String autor, String titulo, String editorial, LocalDate fecha, int unidades, boolean estado) {
        Libro libro = new Libro(codigo, isbn, autor, titulo, editorial, fecha, unidades, estado);
        libros.add(libro);
    }

    public Libro consultarLibroPorCodigo(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null;
    }

    public void crearPrestamo(String codigo, Estudiante estudiante, Bibliotecario bibliotecario) {
        Prestamo prestamo = new Prestamo(codigo, estudiante, bibliotecario);
        prestamos.add(prestamo);
    }

    public Prestamo consultarPrestamoPorCodigo(String codigo) {
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getCodigo().equals(codigo)) {
                return prestamo;
            }
        }
        return null;
    }

    public void mostrarCantidadPrestamosPorEmpleado() {
        for (Bibliotecario bibliotecario : bibliotecarios) {
            int count = 0;
            for (Prestamo prestamo : prestamos) {
                if (prestamo.getBibliotecario().equals(bibliotecario)) {
                    count++;
                }
            }
            System.out.println(bibliotecario.getNombre() + " ha realizado " + count + " préstamos.");
        }
    }

    public double calcularTotalDineroRecaudado() {
        double total = 0;
        for (Prestamo prestamo : prestamos) {
            total += prestamo.getCosto();
        }
        return total;
    }

    public static void main(String[] args) {
        // Ejemplo de creación de una biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca CRAI", "Armenia Quindío", 1500000, 3000);
        System.out.println("Nombre de la biblioteca: " + biblioteca.getNombre());
        System.out.println("Ubicación: " + biblioteca.getUbicacion());
        System.out.println("Ganancia: " + biblioteca.getGanancia());
        System.out.println("Cantidad de libros: " + biblioteca.getCantidadLibros());

        // Crear bibliotecarios
        biblioteca.crearBibliotecario("Juan Pérez", "1090274138", "juanp.20@gmail.com", 32445870, 1000000.0, 5);

        // Crear estudiantes
        biblioteca.crearEstudiante("Ana Gómez", "1090285639", "anaG.17@gmail.com", 32890130, 28);

        // Crear libros
        biblioteca.crearLibro("001", "00001", "Edgar Allan Poe", "El cuervo", "New-York Mirror", LocalDate.parse("1845-01-29"), 10, true);
        biblioteca.crearLibro("002", "00002", "Edgar Allan Poe", "Annabel Lee", "Sartain's Union Magazine", LocalDate.parse("1849-10-09"), 5, true);

        // Consultar libro por código
        Libro libroConsultado = biblioteca.consultarLibroPorCodigo("002");
        if (libroConsultado != null) {
            System.out.println("Libro encontrado: " + libroConsultado.getTitulo());
        } else {
            System.out.println("Libro no encontrado.");
        }

        // Crear préstamo
        Estudiante estudiante = biblioteca.estudiantes.get(0); 
        Bibliotecario bibliotecario = biblioteca.bibliotecarios.get(0); 
        biblioteca.crearPrestamo("P001", estudiante, bibliotecario);

        // Consultar préstamo por código
        Prestamo prestamoConsultado = biblioteca.consultarPrestamoPorCodigo("P001");
        if (prestamoConsultado != null) {
            System.out.println("Préstamo encontrado: " + prestamoConsultado.getCodigo());
        } else {
            System.out.println("Préstamo no encontrado.");
        }

        // Mostrar cantidad de préstamos por empleado
        biblioteca.mostrarCantidadPrestamosPorEmpleado();

        // Calcular total de dinero recaudado
        double totalDineroRecaudado = biblioteca
                .calcularTotalDineroRecaudado();
        System.out.println("Total de dinero recaudado: " + totalDineroRecaudado);
    }
}
