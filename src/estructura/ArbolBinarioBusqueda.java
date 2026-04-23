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

        if (producto.getId() < actual.getProducto().getId()) {
            actual.setIzquierdo(insertarRecursivo(actual.getIzquierdo(), producto));
        } 
        else if (producto.getId() > actual.getProducto().getId()) {
            actual.setDerecho(insertarRecursivo(actual.getDerecho(), producto));
        }

        return actual;
    }

    /**
     * Busca un producto por ID.
     */
    public Producto buscar(int id) {

        Nodo resultado = buscarRecursivo(raiz, id);

        if (resultado != null) {
            return resultado.getProducto();
        }

        return null;
    }

    private Nodo buscarRecursivo(Nodo actual, int id) {

        if (actual == null) {
            return null;
        }

        if (actual.getProducto().getId() == id) {
            return actual;
        }

        if (id < actual.getProducto().getId()) {
            return buscarRecursivo(actual.getIzquierdo(), id);
        } else {
            return buscarRecursivo(actual.getDerecho(), id);
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

        if (id < actual.getProducto().getId()) {
            actual.setIzquierdo(eliminarRecursivo(actual.getIzquierdo(), id));
        } 
        else if (id > actual.getProducto().getId()) {
            actual.setDerecho(eliminarRecursivo(actual.getDerecho(), id));
        } 
        else {

            // Caso 1: nodo sin hijos
            if (actual.getIzquierdo() == null && actual.getDerecho() == null) {
                return null;
            }

            // Caso 2: nodo con un hijo
            if (actual.getIzquierdo() == null) {
                return actual.getDerecho();
            }

            if (actual.getDerecho() == null) {
                return actual.getIzquierdo();
            }

            // Caso 3: nodo con dos hijos
            Nodo sucesor = encontrarMinimo(actual.getDerecho());

            actual.setProducto(sucesor.getProducto());

            actual.setDerecho(
                    eliminarRecursivo(
                            actual.getDerecho(),
                            sucesor.getProducto().getId()));
        }

        return actual;
    }

    /**
     * Encuentra el nodo con el valor mínimo.
     */
    private Nodo encontrarMinimo(Nodo nodo) {

        while (nodo.getIzquierdo() != null) {
            nodo = nodo.getIzquierdo();
        }

        return nodo;
    }

    /**
     * Recorrido InOrden del árbol.
     */
    public void mostrarInOrden() {
        inOrdenRecursivo(raiz);
    }

    private void inOrdenRecursivo(Nodo actual) {

        if (actual != null) {

            inOrdenRecursivo(actual.getIzquierdo());

            System.out.println(actual.getProducto());

            inOrdenRecursivo(actual.getDerecho());
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

        double subtotal = actual.getProducto().calcularSubtotal();

        return subtotal
                + calcularTotalRecursivo(actual.getIzquierdo())
                + calcularTotalRecursivo(actual.getDerecho());
    }

    /**
     * Genera el ticket de venta como texto (para GUI o consola).
     */
    public String generarTicket() {

        StringBuilder ticket = new StringBuilder();

        ticket.append("\n====== TICKET DE COMPRA ======\n");
        ticket.append("ID | Producto | Cantidad | Precio | Subtotal\n");

        generarTicketRecursivo(raiz, ticket);

        ticket.append("--------------------------------\n");
        ticket.append("TOTAL: ").append(calcularTotal());

        return ticket.toString();
    }

    private void generarTicketRecursivo(Nodo actual, StringBuilder ticket) {

        if (actual != null) {

            generarTicketRecursivo(actual.getIzquierdo(), ticket);

            Producto p = actual.getProducto();

            ticket.append(
                    p.getId()).append(" | ")
                    .append(p.getNombre()).append(" | ")
                    .append(p.getCantidad()).append(" | ")
                    .append(p.getPrecioUnitario()).append(" | ")
                    .append(p.calcularSubtotal()).append("\n");

            generarTicketRecursivo(actual.getDerecho(), ticket);
        }
    }
}