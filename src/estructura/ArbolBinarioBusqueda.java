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

public void eliminar(int id) {
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

        // Caso 2: nodo con un solo hijo
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

private Nodo encontrarMinimo(Nodo nodo) {

    while (nodo.izquierdo != null) {
        nodo = nodo.izquierdo;
    }

    return nodo;
}
}
