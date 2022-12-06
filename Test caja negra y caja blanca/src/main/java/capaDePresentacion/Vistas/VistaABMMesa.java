package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Mesa;
import capaDeDatos.Producto;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaABMMesa extends JFrame implements IVista{
	private JPanel contentPane;
	private JComboBox<Mesa> comboBoxMesas;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAlta;
	private JButton btnAtras;
	private JLabel lblNewLabel;

	

	/**
	 * Create the frame.
	 */
	public VistaABMMesa() {
		setTitle("ABM mesas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 274, 296);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.comboBoxMesas = new JComboBox();
		this.comboBoxMesas.setBounds(25, 51, 211, 22);
		this.contentPane.add(this.comboBoxMesas);
		
		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setBounds(25, 133, 89, 23);
		this.contentPane.add(this.btnModificar);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setBounds(147, 133, 89, 23);
		this.contentPane.add(this.btnEliminar);
		
		this.btnAlta = new JButton("Agregar");
		this.btnAlta.setBounds(86, 174, 89, 23);
		this.contentPane.add(this.btnAlta);
		
		this.btnAtras = new JButton("Atras");
		this.btnAtras.setBounds(178, 230, 77, 22);
		this.contentPane.add(this.btnAtras);
		
		this.lblNewLabel = new JLabel("ABM mesas");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel.setBounds(75, 11, 149, 22);
		this.contentPane.add(this.lblNewLabel);
		
		setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAlta.addActionListener(listener);
		this.btnAlta.setActionCommand(IVista.AGREGAR_MESA);
		this.btnEliminar.addActionListener(listener);
		this.btnEliminar.setActionCommand(IVista.ELIMINAR_MESA);
		this.btnModificar.addActionListener(listener);
		this.btnModificar.setActionCommand(IVista.MODIFICAR_MESA);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(IVista.SALIR_DE_MESA);
	}

	@Override
	public void cerrar() {
		setVisible(false);
	}

	public void actualizaComboBoxMesas(ArrayList<Mesa> mesas) {
		this.comboBoxMesas.removeAllItems();
		for(Mesa i: mesas)
			comboBoxMesas.addItem(i);
	}
	
	public Mesa getMesa() {
		return (Mesa) this.comboBoxMesas.getSelectedItem();
	}
}
