package ui;

import estructura.ArbolBinarioBusqueda;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private ArbolBinarioBusqueda arbol;

    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtCantidad;
    private JTextField txtPrecio;

    private JTextArea areaSalida;

    public VentanaPrincipal() {

        arbol = new ArbolBinarioBusqueda();

        setTitle("Sistema de Ventas - ABB");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(4,2));

        panelFormulario.add(new JLabel("ID"));
        txtId = new JTextField();
        panelFormulario.add(txtId);

        panelFormulario.add(new JLabel("Nombre"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Cantidad"));
        txtCantidad = new JTextField();
        panelFormulario.add(txtCantidad);

        panelFormulario.add(new JLabel("Precio"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        add(panelFormulario, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();

        JButton btnInsertar = new JButton("Insertar");
        JButton btnBuscar = new JButton("Buscar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnTicket = new JButton("Ticket");

        panelBotones.add(btnInsertar);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnTicket);

        add(panelBotones, BorderLayout.CENTER);

        areaSalida = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaSalida);

        add(scroll, BorderLayout.SOUTH);

        btnInsertar.addActionListener(e -> insertarProducto());
        btnBuscar.addActionListener(e -> buscarProducto());
        btnEliminar.addActionListener(e -> eliminarProducto());
        btnTicket.addActionListener(e -> mostrarTicket());
    }

    private void insertarProducto() {

        try {

            int id = Integer.parseInt(txtId.getText());
            String nombre = txtNombre.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());

            Producto p = new Producto(id,nombre,cantidad,precio);

            arbol.insertar(p);

            areaSalida.append("Producto insertado\n");

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this,"Error en los datos");

        }

    }

    private void buscarProducto() {

        try {

            int id = Integer.parseInt(txtId.getText());

            Producto p = arbol.buscar(id);

            if(p != null)
                areaSalida.append("Encontrado: " + p + "\n");
            else
                areaSalida.append("No encontrado\n");

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this,"Error en ID");

        }

    }

    private void eliminarProducto() {

        try {

            int id = Integer.parseInt(txtId.getText());

            arbol.eliminar(id);

            areaSalida.append("Producto eliminado\n");

        } catch(Exception ex) {

            JOptionPane.showMessageDialog(this,"Error en ID");

        }

    }

    private void mostrarTicket() {

        areaSalida.append("\n--- TICKET ---\n");
        arbol.generarTicket();

    }

}