package estructura;

import modelo.Producto;

/**
 * Implementación de un Árbol Binario de Búsqueda (ABB)
 * para almacenar productos del supermercado.
 */
public class ArbolBinarioBusqueda {

    private Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    /**
     * Inserta un producto en el árbol.
     * No permite IDs duplicados.
     */
    public void insertar(Producto producto) {

        if (buscar(producto.getId()) != null) {
            System.out.println("Error: Ya existe un producto con ese ID.");
            return;
        }

        raiz = insertarRecursivo(raiz, producto);
    }

    private Nodo insertarRecursivo(Nodo actual, Producto producto) {

        if (actual == null) {
            return new Nodo(producto);
        }

        if (producto.getId() < actual.producto.getId()) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, producto);
        } 
        else if (producto.getId() > actual.producto.getId()) {
            actual.derecho = insertarRecursivo(actual.derecho, producto);
        }

        return actual;
    }

    /**
     * Busca un producto por ID.
     */
    public Producto buscar(int id) {

        Nodo resultado = buscarRecursivo(raiz, id);

        if (resultado != null) {
            return resultado.producto;
        }

        return null;
    }

    private Nodo buscarRecursivo(Nodo actual, int id) {

        if (actual == null) {
            return null;
        }

        if (actual.producto.getId() == id) {
            return actual;
        }

        if (id < actual.producto.getId()) {
            return buscarRecursivo(actual.izquierdo, id);
        } else {
            return buscarRecursivo(actual.derecho, id);
        }
    }

    /**
     * Elimina un producto del árbol.
     */
    public void eliminar(int id) {

        if (buscar(id) == null) {
            System.out.println("No existe un producto con ese ID.");
            return;
        }

        raiz = eliminarRecursivo(raiz, id);
    }

    private Nodo eliminarRecursivo(Nodo actual, int id) {

        if (actual == null) {
            return null;
        }

        if (id < actual.producto.getId()) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, id);
        } 
        else if (id > actual.producto.getId()) {
            actual.derecho = eliminarRecursivo(actual.derecho, id);
        } 
        else {

            // Caso 1: nodo sin hijos
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }

            // Caso 2: nodo con un hijo
            if (actual.izquierdo == null) {
                return actual.derecho;
            }

            if (actual.derecho == null) {
                return actual.izquierdo;
            }

            // Caso 3: nodo con dos hijos
            Nodo sucesor = encontrarMinimo(actual.derecho);

            actual.producto = sucesor.producto;

            actual.derecho = eliminarRecursivo(actual.derecho, sucesor.producto.getId());
        }

        return actual;
    }

    /**
     * Encuentra el nodo con el valor mínimo (más a la izquierda).
     */
    private Nodo encontrarMinimo(Nodo nodo) {

        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }

        return nodo;
    }

    /**
     * Muestra el recorrido del árbol en orden.
     */
    public void mostrarInOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo actual) {

        if (actual != null) {

            inOrdenRecursivo(actual.izquierdo);

            System.out.println(actual.producto);

            inOrdenRecursivo(actual.derecho);
        }
    }

    /**
     * Calcula el total de la compra recorriendo el árbol.
     */
    public double calcularTotal() {
        return calcularTotalRecursivo(raiz);
    }

    private double calcularTotalRecursivo(Nodo actual) {

        if (actual == null) {
            return 0;
        }

        double subtotal = actual.producto.calcularSubtotal();

        return subtotal
                + calcularTotalRecursivo(actual.izquierdo)
                + calcularTotalRecursivo(actual.derecho);
    }

    /**
     * Genera el ticket de venta por consola.
     */
    public void generarTicket() {

        System.out.println("\n====== TICKET DE COMPRA ======");
        System.out.println("ID | Producto | Cantidad | Precio | Subtotal");

        generarTicketRecursivo(raiz);

        System.out.println("--------------------------------");
        System.out.println("TOTAL: " + calcularTotal());
    }

    private void generarTicketRecursivo(Nodo actual) {

        if (actual != null) {

            generarTicketRecursivo(actual.izquierdo);

            Producto p = actual.producto;

            System.out.println(
                    p.getId() + " | "
                    + p.getNombre() + " | "
                    + p.getCantidad() + " | "
                    + p.getPrecioUnitario() + " | "
                    + p.calcularSubtotal()
            );

            generarTicketRecursivo(actual.derecho);
        }
    }
}