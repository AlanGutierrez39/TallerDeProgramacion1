package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;

public class VistaAltaOperario extends JFrame implements IVista{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel_2;
	private JTextField textFieldNombreUsuario;
	private JLabel lblNewLabel_3;
	private JTextField textFieldPassword;
	private JLabel lblNewLabel_4;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JComboBox comboBoxActivo;
	private JLabel lblNewLabel_informa;


	/**
	 * Create the frame.
	 */
	public VistaAltaOperario() {
		setTitle("Agregar operario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 306, 366);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		setLocationRelativeTo(null);
		this.lblNewLabel = new JLabel("Agregar Operario");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		this.lblNewLabel.setBounds(56, 0, 203, 32);
		this.contentPane.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("Nombre y apellido");
		this.lblNewLabel_1.setBounds(20, 72, 143, 23);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.textFieldNombre = new JTextField();
		this.textFieldNombre.setBounds(173, 73, 86, 20);
		this.contentPane.add(this.textFieldNombre);
		this.textFieldNombre.setColumns(10);
		
		this.lblNewLabel_2 = new JLabel("Nombre usuario");
		this.lblNewLabel_2.setBounds(20, 124, 143, 20);
		this.contentPane.add(this.lblNewLabel_2);
		
		this.textFieldNombreUsuario = new JTextField();
		this.textFieldNombreUsuario.setBounds(173, 124, 86, 20);
		this.contentPane.add(this.textFieldNombreUsuario);
		this.textFieldNombreUsuario.setColumns(10);
		
		this.lblNewLabel_3 = new JLabel("Password");
		this.lblNewLabel_3.setBounds(20, 180, 143, 14);
		this.contentPane.add(this.lblNewLabel_3);
		
		this.textFieldPassword = new JTextField();
		this.textFieldPassword.setBounds(173, 177, 86, 20);
		this.contentPane.add(this.textFieldPassword);
		this.textFieldPassword.setColumns(10);
		
		this.lblNewLabel_4 = new JLabel("Activo");
		this.lblNewLabel_4.setBounds(20, 232, 46, 14);
		this.contentPane.add(this.lblNewLabel_4);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(26, 289, 89, 23);
		this.contentPane.add(this.btnCancelar);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(170, 289, 89, 23);
		this.contentPane.add(this.btnConfirmar);
		
		this.comboBoxActivo = new JComboBox<>();
		this.comboBoxActivo.setBounds(173, 228, 86, 18);
		this.contentPane.add(this.comboBoxActivo);
		this.comboBoxActivo.addItem((String) "true");
		this.comboBoxActivo.addItem((String) "false");
		
		this.lblNewLabel_informa = new JLabel("");
		this.lblNewLabel_informa.setForeground(Color.RED);
		this.lblNewLabel_informa.setBounds(30, 258, 229, 20);
		this.contentPane.add(this.lblNewLabel_informa);
		
		setVisible(true);
	}
	
	public String getNombre() {
		return this.textFieldNombre.getText();
	}
	
	public String getNombreUsuario() {
		return this.textFieldNombreUsuario.getText();
	}
	public String getPassword() {
		return this.textFieldPassword.getText();
	}
	public boolean getActivo() {
		return this.comboBoxActivo.getSelectedItem().toString().equals("true");
	}
	
	public void setLabelInforma(String mensaje) {
		this.lblNewLabel_informa.setText(mensaje);
	}
	
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnConfirmar.addActionListener(listener);
		this.btnConfirmar.setActionCommand(IVista.CONFIRMAR_OPERARIO);
		this.btnCancelar.addActionListener(listener);
		this.btnCancelar.setActionCommand(IVista.CANCELAR_OPERARIO);
	}

	@Override
	public void cerrar() {
		setVisible(false);
	}
}
