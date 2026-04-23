# supermercado-arboles-java
Proyecto III - Árbol Binario de Búsqueda para registro de ventas de supermercado

## Funcionamiento del Proyecto

Este proyecto implementa un **Sistema de Gestión de Productos utilizando un Árbol Binario de Búsqueda (ABB)** en Java. El sistema permite almacenar, buscar, eliminar y visualizar productos de manera eficiente utilizando la estructura de datos del árbol.

### Estructura del Proyecto

El proyecto está organizado en los siguientes paquetes:

* **modelo**

  * Contiene la clase `Producto`, que representa los datos de cada producto.

* **estructura**

  * `Nodo`: representa cada nodo del árbol.
  * `ArbolBinarioBusqueda`: implementa la lógica del árbol, incluyendo inserción, búsqueda, eliminación y generación del ticket.

* **ui**

  * `VentanaPrincipal`: interfaz gráfica construida con Swing.
  * `PanelArbol`: panel encargado de dibujar visualmente el árbol binario.

* **app**

  * `Main`: punto de entrada de la aplicación.

---

### Funcionalidades del Sistema

El sistema permite realizar las siguientes operaciones:

#### Insertar producto

El usuario puede ingresar:

* ID
* Nombre
* Cantidad
* Precio unitario

El producto se inserta en el Árbol Binario de Búsqueda utilizando el **ID como clave**, manteniendo el orden del árbol.

Después de insertar un producto:

* El árbol se actualiza visualmente.
* Los campos de entrada se limpian automáticamente.

---

#### Buscar producto

El usuario puede buscar un producto ingresando su **ID**.

El sistema:

* Busca el producto en el árbol.
* Muestra los datos en los campos de la interfaz.
* **Resalta visualmente el nodo encontrado** en el árbol para proporcionar retroalimentación visual.

---

#### Eliminar producto

Permite eliminar un producto del árbol utilizando su **ID**.

La eliminación contempla los tres casos clásicos de los árboles binarios de búsqueda:

1. Nodo sin hijos
2. Nodo con un solo hijo
3. Nodo con dos hijos (se reemplaza por el sucesor en orden)

El árbol se redibuja automáticamente después de la eliminación.

---

#### Visualización del árbol

El sistema dibuja gráficamente el Árbol Binario de Búsqueda utilizando Java Swing.

Cada nodo muestra el **ID del producto**, y se dibujan las conexiones entre nodos padre e hijos.

---

#### Generación de ticket

El sistema puede generar un **ticket de compra** que incluye:

* ID del producto
* Nombre
* Cantidad
* Precio unitario
* Subtotal por producto

El ticket también calcula automáticamente el **total de la compra**.

El ticket se muestra directamente dentro de la interfaz gráfica.

---

### Tecnologías utilizadas

* Java
* Java Swing
* Árbol Binario de Búsqueda (ABB)
* Programación orientada a objetos

---

### Objetivo académico

El objetivo de este proyecto es aplicar conceptos de:

* Estructuras de datos (Árbol Binario de Búsqueda)
* Programación orientada a objetos
* Desarrollo de interfaces gráficas con Swing
* Integración entre lógica de negocio y visualización de datos
