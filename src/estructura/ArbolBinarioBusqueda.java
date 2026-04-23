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
    
    public void insertar(Producto producto) {
    raiz = insertarRecursivo(raiz, producto);
}

private Nodo insertarRecursivo(Nodo actual, Producto producto) {

    if (actual == null) {
        return new Nodo(producto);
    }

    if (producto.getId() < actual.producto.getId()) {
        actual.izquierdo = insertarRecursivo(actual.izquierdo, producto);
    } else if (producto.getId() > actual.producto.getId()) {
        actual.derecho = insertarRecursivo(actual.derecho, producto);
    }

    return actual;
}

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

public double calcularTotal() {
    return calcularTotalRecursivo(raiz);
}

private double calcularTotalRecursivo(Nodo actual) {

    if (actual == null) {
        return 0;
    }

    double subtotal = actual.producto.calcularSubtotal();

    return subtotal +
           calcularTotalRecursivo(actual.izquierdo) +
           calcularTotalRecursivo(actual.derecho);
}
}
