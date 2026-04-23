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
}
