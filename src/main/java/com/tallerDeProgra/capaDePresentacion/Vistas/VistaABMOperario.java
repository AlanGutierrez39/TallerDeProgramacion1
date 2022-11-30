package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
import com.tallerDeProgra.capaDeNegocios.Sistema;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Font;

public class VistaABMOperario extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel panel;
	private JComboBox<Operario> comboBoxOperarios;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnAtras;

	/**
	 * Create the frame.
	 */
	public VistaABMOperario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 256);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		setLocationRelativeTo(null);
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
//		-------------------------------------------------------
		this.comboBoxOperarios = new JComboBox<Operario>();				
		this.comboBoxOperarios.setBounds(10, 11, 246, 23);
		this.panel.add(this.comboBoxOperarios);
//		-------------------------------------------------------
		
		this.btnModificar = new JButton("Modificar");
		this.btnModificar.setBounds(26, 99, 89, 23);
		this.panel.add(this.btnModificar);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setBounds(143, 99, 89, 23);
		this.panel.add(this.btnEliminar);
		
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setBounds(89, 133, 89, 23);
		this.panel.add(this.btnAgregar);
		
		this.btnAtras = new JButton("Atras");
		this.btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.btnAtras.setBounds(190, 174, 66, 22);
		this.panel.add(this.btnAtras);
		
		setVisible(true);
	}

	
	public void actualizaComboBoxOperarios(ArrayList<Operario> operarios, ArrayList<OperarioAdministrador> operariosAdministrador) {
		this.comboBoxOperarios.removeAllItems();
		for(Operario i: operarios)
			comboBoxOperarios.addItem(i);
		for(OperarioAdministrador i: operariosAdministrador)
			comboBoxOperarios.addItem(i);
	}
	
	public void cerrar() {
		setVisible(false);
	}
	
	public Operario getOperario() {
		return (Operario) this.comboBoxOperarios.getSelectedItem();
	}
	
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnAgregar.setActionCommand(IVista.AGREGAR_OPERARIO);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(IVista.SALIR_DE_OPERARIO);
		this.btnEliminar.addActionListener(listener);
		this.btnEliminar.setActionCommand(IVista.ELIMINAR_OPERARIO);
		this.btnModificar.addActionListener(listener);
		this.btnModificar.setActionCommand(IVista.MODIFICAR_OPERARIO);
	}
}