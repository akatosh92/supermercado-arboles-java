package modelo;

/**
 * Clase que representa un producto dentro del sistema de ventas.
 * Cada producto será almacenado en un nodo del Árbol Binario de Búsqueda.
 */
public class Producto {

    private int id;
    private String nombre;
    private int cantidad;
    private double precioUnitario;

    public Producto(int id, String nombre, int cantidad, double precioUnitario) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Calcula el subtotal del producto (cantidad × precio)
     */
    public double calcularSubtotal() {
        return cantidad * precioUnitario;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Producto: " + nombre +
               " | Cantidad: " + cantidad +
               " | Precio: $" + precioUnitario +
               " | Subtotal: $" + calcularSubtotal();
    }
}