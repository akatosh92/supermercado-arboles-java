package ui;

import estructura.ArbolBinarioBusqueda;
import estructura.Nodo;
import java.awt.*;
import javax.swing.JPanel;

public class PanelArbol extends JPanel {

    private ArbolBinarioBusqueda arbol;

    public PanelArbol(ArbolBinarioBusqueda arbol) {
        this.arbol = arbol;
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Nodo raiz = arbol.getRaiz();

        if (raiz != null) {
            dibujarNodo(g, raiz, getWidth() / 2, 40, getWidth() / 4);
        }
    }

    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int offset) {

        int radio = 30;

        g.setColor(Color.BLACK);

        // Texto del nodo
        String texto = String.valueOf(nodo.getProducto().getId());

        // Dibujar círculo
        g.setColor(new Color(200, 220, 255));
        g.fillOval(x - radio / 2, y - radio / 2, radio, radio);

        g.setColor(Color.BLACK);
        g.drawOval(x - radio / 2, y - radio / 2, radio, radio);

        // Centrar texto
        FontMetrics fm = g.getFontMetrics();
        int textoX = x - fm.stringWidth(texto) / 2;
        int textoY = y + fm.getAscent() / 2 - 2;

        g.drawString(texto, textoX, textoY);

        // Hijo izquierdo
        if (nodo.getIzquierdo() != null) {

            int xIzq = x - offset;
            int yIzq = y + 60;

            g.drawLine(x, y, xIzq, yIzq);

            dibujarNodo(g, nodo.getIzquierdo(), xIzq, yIzq, offset / 2);
        }

        // Hijo derecho
        if (nodo.getDerecho() != null) {

            int xDer = x + offset;
            int yDer = y + 60;

            g.drawLine(x, y, xDer, yDer);

            dibujarNodo(g, nodo.getDerecho(), xDer, yDer, offset / 2);
        }
    }
}