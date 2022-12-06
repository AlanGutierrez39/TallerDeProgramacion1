package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Producto;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VistaAltaPedido extends JFrame implements IVista{

	private JPanel contentPane;
	private JTextField textFieldCantidad;
	private JButton btnCrearPedido = new JButton("Crear pedido");
	private JButton btnAtras = new JButton("Atras");
	private JComboBox comboBoxProductos = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaPedido frame = new VistaAltaPedido();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaAltaPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblAgregarPedido = new JLabel("Agregar pedido");
		lblAgregarPedido.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAgregarPedido.setBounds(130, 11, 203, 32);
		contentPane.add(lblAgregarPedido);
		
		JLabel lblNewLabel_1 = new JLabel("Cantidad:");
		lblNewLabel_1.setBounds(62, 142, 95, 23);
		contentPane.add(lblNewLabel_1);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setColumns(10);
		textFieldCantidad.setBounds(100, 165, 48, 20);
		contentPane.add(textFieldCantidad);
		
		btnCrearPedido.setBounds(237, 227, 122, 23);
		contentPane.add(btnCrearPedido);
		
		btnAtras.setBounds(79, 227, 80, 23);
		contentPane.add(btnAtras);
		
		comboBoxProductos.setBounds(79, 98, 219, 22);
		contentPane.add(comboBoxProductos);
		
		JLabel lblNewLabel = new JLabel("Seleccione producto de la lista:");
		lblNewLabel.setBounds(62, 73, 236, 14);
		contentPane.add(lblNewLabel);
		this.setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(ATRAS_PEDIDO);
		this.btnCrearPedido.addActionListener(listener);
		this.btnCrearPedido.setActionCommand(CONFIRMAR_PEDIDO);
		
	}

	public void actualizaComboBoxProductos(ArrayList<Producto> productos) {
		this.comboBoxProductos.removeAllItems();
		for(Producto i: productos)
			this.comboBoxProductos.addItem(i);
	}
	
	public Producto getProducto() {
		return (Producto) this.comboBoxProductos.getSelectedItem();
	}

	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}

	public String getCantidad() {
		return this.textFieldCantidad.getText();
	}
	

}
