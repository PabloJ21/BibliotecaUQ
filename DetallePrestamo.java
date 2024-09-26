public class DetallePrestamo {

    private int cantidad;
    private double subTotal;
    private Libro libro;

    public DetallePrestamo(int cantidad, Libro libro){
        this.cantidad=cantidad;
        this.libro=libro;
        this.subTotal=0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "DetallePrestamo [cantidad=" + cantidad + ", subTotal=" + subTotal + ", libro=" + libro + "]";
    }
    
}