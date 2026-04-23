package ui;

import estructura.ArbolBinarioBusqueda;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private ArbolBinarioBusqueda arbol;
    private PanelArbol panelArbol;

    private JTextField campoId;
    private JTextField campoNombre;
    private JTextField campoCantidad;
    private JTextField campoPrecio;

    private JTextArea areaTicket;

    public VentanaPrincipal() {

        arbol = new ArbolBinarioBusqueda();

        setTitle("Sistema de Ventas con ABB");
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // PANEL DEL ARBOL
        panelArbol = new PanelArbol(arbol);
        add(panelArbol, BorderLayout.CENTER);

        // PANEL DE CONTROLES
        JPanel panelControles = new JPanel(new GridLayout(6,2));

        panelControles.add(new JLabel("ID:"));
        campoId = new JTextField();
        panelControles.add(campoId);

        panelControles.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panelControles.add(campoNombre);

        panelControles.add(new JLabel("Cantidad:"));
        campoCantidad = new JTextField();
        panelControles.add(campoCantidad);

        panelControles.add(new JLabel("Precio:"));
        campoPrecio = new JTextField();
        panelControles.add(campoPrecio);

        JButton btnInsertar = new JButton("Insertar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnTicket = new JButton("Generar Ticket");

        panelControles.add(btnInsertar);
        panelControles.add(btnEliminar);
        panelControles.add(btnBuscar);
        panelControles.add(btnTicket);

        add(panelControles, BorderLayout.WEST);

        // AREA DEL TICKET
        areaTicket = new JTextArea();
        areaTicket.setEditable(false);

        JScrollPane scrollTicket = new JScrollPane(areaTicket);
        scrollTicket.setPreferredSize(new Dimension(300,0));

        add(scrollTicket, BorderLayout.EAST);

        // BOTON INSERTAR
        btnInsertar.addActionListener(e -> {

            try {

                int id = Integer.parseInt(campoId.getText());
                String nombre = campoNombre.getText();
                int cantidad = Integer.parseInt(campoCantidad.getText());
                double precio = Double.parseDouble(campoPrecio.getText());

                Producto producto = new Producto(id,nombre,cantidad,precio);

                arbol.insertar(producto);

                panelArbol.repaint();
                
                // LIMPIAR CAMPOS
                campoId.setText("");
                campoNombre.setText("");
                campoCantidad.setText("");
                campoPrecio.setText("");

                // Regresar el cursor al campo ID
                campoId.requestFocus();
            
            } catch (Exception ex) {
                
                JOptionPane.showMessageDialog(this,"Datos inválidos");
            
            }

        });

        // BOTON ELIMINAR
        btnEliminar.addActionListener(e -> {

            try {

                int id = Integer.parseInt(campoId.getText());

                arbol.eliminar(id);

                panelArbol.repaint();

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,"ID inválido");

            }

        });
        
        // BOTON BUSCAR
        btnBuscar.addActionListener(e -> {
            
            try {
                
                int id = Integer.parseInt(campoId.getText());
                
                Producto producto = arbol.buscar(id);
                
                if (producto != null) {
                    
                    campoNombre.setText(producto.getNombre());
                    campoCantidad.setText(String.valueOf(producto.getCantidad()));
                    campoPrecio.setText(String.valueOf(producto.getPrecioUnitario()));
                
                } else {
                    JOptionPane.showMessageDialog(this,"Producto no encontrado");
                }
            
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"ID inválido");
            }
        
        });

        // BOTON TICKET
        btnTicket.addActionListener(e -> {

            areaTicket.setText(arbol.generarTicket());

        });

    }

}