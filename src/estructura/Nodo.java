package estructura;

import modelo.Producto;

/**
 * Representa un nodo dentro del Árbol Binario de Búsqueda.
 * Cada nodo contiene un producto y referencias a sus hijos.
 */
public class Nodo {

    Producto producto;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(Producto producto) {
        this.producto = producto;
        this.izquierdo = null;
        this.derecho = null;
    }

}
