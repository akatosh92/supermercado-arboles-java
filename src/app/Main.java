package app;

import estructura.ArbolBinarioBusqueda;
import modelo.Producto;

public class Main {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        System.out.println("=== INSERTANDO PRODUCTOS ===");

        arbol.insertar(new Producto(10, "Leche", 2, 1200));
        arbol.insertar(new Producto(5, "Pan", 1, 900));
        arbol.insertar(new Producto(20, "Arroz", 3, 800));
        arbol.insertar(new Producto(3, "Huevos", 1, 2500));
        arbol.insertar(new Producto(15, "Cafe", 1, 3500));

        arbol.insertar(new Producto(10, "Duplicado", 1, 1000));

        System.out.println("\n=== RECORRIDO INORDEN ===");
        arbol.mostrarInOrden();

        System.out.println("\n=== BUSQUEDA ===");
        Producto buscado = arbol.buscar(5);

        if (buscado != null) {
            System.out.println("Producto encontrado:");
            System.out.println(buscado);
        } else {
            System.out.println("Producto no encontrado");
        }

        System.out.println("\n=== ELIMINANDO PRODUCTO ID 5 ===");
        arbol.eliminar(5);

        System.out.println("\n=== INTENTANDO ELIMINAR ID INEXISTENTE ===");
        arbol.eliminar(99);

        System.out.println("\n=== RECORRIDO DESPUES DE ELIMINAR ===");
        arbol.mostrarInOrden();

        System.out.println("\n=== TICKET DE COMPRA ===");
        arbol.generarTicket();
    }
}
