package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Operario;
import capaDeDatos.OperarioAdministrador;
import capaDeDatos.Producto;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VistaABMProducto extends JFrame implements IVista {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JComboBox<Producto> comboBoxProductos;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAlta;
	private JLabel lblNewLabel_1;
	private JTextField textFieldCantStock;
	private JButton btnActualizaStock;
	private JButton btnAtras;


	/**
	 * Create the frame.
	 */
	public VistaABMProducto() {
		setTitle("ABM producto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 351);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		this.lblNewLabel = new JLabel("Producto");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		this.lblNewLabel.setBounds(93, 11, 171, 22);
		this.contentPane.add(this.lblNewLabel);
		
		this.comboBoxProductos = new JComboBox<Producto>();
		this.comboBoxProductos.setBounds(10, 49, 276, 22);
		this.contentPane.add(this.comboBoxProductos);
		
		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setBounds(33, 122, 89, 23);
		this.contentPane.add(this.btnModificar);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setBounds(164, 122, 89, 23);
		this.contentPane.add(this.btnEliminar);
		
		this.btnAlta = new JButton("Agregar");
		this.btnAlta.setBounds(98, 168, 89, 23);
		this.contentPane.add(this.btnAlta);
		
		this.lblNewLabel_1 = new JLabel("Cantidad stock");
		this.lblNewLabel_1.setBounds(33, 216, 110, 22);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.textFieldCantStock = new JTextField();
		this.textFieldCantStock.setBounds(153, 217, 86, 20);
		this.contentPane.add(this.textFieldCantStock);
		this.textFieldCantStock.setColumns(10);
		
		this.btnActualizaStock = new JButton("Actualizar stock");
		this.btnActualizaStock.setBounds(131, 248, 133, 20);
		this.contentPane.add(this.btnActualizaStock);
		
		this.btnAtras = new JButton("Atras");
		this.btnAtras.setBounds(218, 280, 72, 22);
		this.contentPane.add(this.btnAtras);
		
		setVisible(true);
	}
	
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnActualizaStock.addActionListener(listener);
		this.btnActualizaStock.setActionCommand(IVista.ACTUALIZAR_PRODUCTO);
		this.btnAlta.addActionListener(listener);
		this.btnAlta.setActionCommand(IVista.AGREGAR_PRODUCTO);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(IVista.SALIR_DE_PRODUCTO);
		this.btnEliminar.addActionListener(listener);
		this.btnEliminar.setActionCommand(IVista.ELIMINAR_PRODUCTO);
		this.btnModificar.addActionListener(listener);
		this.btnModificar.setActionCommand(IVista.MODIFICAR_PRODUCTO);
	}
	
	public void actualizaComboBoxProductos(ArrayList<Producto> productos) {
		this.comboBoxProductos.removeAllItems();
		for(Producto i: productos)
			comboBoxProductos.addItem(i);
	}
	
	public Producto getProducto() {
		return (Producto) this.comboBoxProductos.getSelectedItem();
	}
	
	public String getCantActualizar() {
		return this.textFieldCantStock.getText();
	}

	@Override
	public void cerrar() {
		setVisible(false);		
	}
}
