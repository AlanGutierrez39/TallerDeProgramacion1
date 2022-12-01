package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Mozo;
import capaDeDatos.Operario;
import capaDeDatos.Producto;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaABMMozo extends JFrame implements IVista{

	private JPanel contentPane;
	private JComboBox<Mozo> comboBoxMozos;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnAtras;

	
	/**
	 * Create the frame.
	 */
	public VistaABMMozo() {
		setTitle("ABM mozos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 255, 251);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		setLocationRelativeTo(null);
		this.contentPane.setLayout(null);
		
		this.comboBoxMozos = new JComboBox<Mozo>();
		this.comboBoxMozos.setBounds(10, 29, 220, 22);
		this.contentPane.add(this.comboBoxMozos);
		
		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setBounds(10, 80, 91, 22);
		this.contentPane.add(this.btnModificar);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setBounds(141, 80, 89, 23);
		this.contentPane.add(this.btnEliminar);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setBounds(74, 123, 89, 23);
		this.contentPane.add(this.btnAgregar);
		
		this.btnAtras = new JButton("Atras");
		this.btnAtras.setBounds(154, 179, 75, 22);
		this.contentPane.add(this.btnAtras);
		
		setVisible(true);
	}


	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnAgregar.setActionCommand(IVista.AGREGAR_MOZO);
		this.btnEliminar.addActionListener(listener);
		this.btnEliminar.setActionCommand(IVista.ELIMINAR_MOZO);
		this.btnModificar.addActionListener(listener);
		this.btnModificar.setActionCommand(IVista.MODIFICAR_MOZO);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(IVista.SALIR_DE_MOZO);
	}

	@Override
	public void cerrar() {
		setVisible(false);		
	}
	
	public void actualizaComboBoxMozos(ArrayList<Mozo> mozos) {
		this.comboBoxMozos.removeAllItems();
		for(Mozo i: mozos)
			comboBoxMozos.addItem(i);
	}
	
	public Mozo getMozo() {
		return (Mozo) this.comboBoxMozos.getSelectedItem();
	}
}
