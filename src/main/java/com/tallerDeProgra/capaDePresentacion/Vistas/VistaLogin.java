package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Color;

public class VistaLogin extends JFrame implements IVistaLogin{

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelCentral;
	private JLabel lblNewLabel;
	private JTextField textField_Nombre;
	private JLabel lblNewLabel_1;
	private JTextField textField_Contrasenia;
	private JLabel lblNewLabel_2;
	private JButton btnIngresar;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_Contrasenia;
	private JPanel panel_4;
	private JPanel panel_Nombre;
	public JPanel getPanel_5() {
		return panel_Nombre;
	}


	public void setPanel_5(JPanel panel_5) {
		this.panel_Nombre = panel_5;
	}


	private JLabel lblUsuarioIncorrecto;
	private JLabel lblPasswordIncorrecto;

	/**
	 * Create the frame.
	 */
	public VistaLogin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 267, 357);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		setLocationRelativeTo(null);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.NORTH);
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(3, 2, 0, 0));
		
		this.panel_4 = new JPanel();
		this.panelCentral.add(this.panel_4);
		this.panel_4.setLayout(null);
		
		this.lblNewLabel = new JLabel("Nombre");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.lblNewLabel.setBounds(36, 37, 49, 17);
		this.panel_4.add(this.lblNewLabel);
		
		this.panel_Nombre = new JPanel();
		this.panelCentral.add(this.panel_Nombre);
		this.panel_Nombre.setLayout(null);
		
		this.textField_Nombre = new JTextField();
		this.textField_Nombre.setBounds(10, 37, 100, 20);
		this.panel_Nombre.add(this.textField_Nombre);
		this.textField_Nombre.setColumns(10);
		
		this.lblUsuarioIncorrecto = new JLabel("");
		this.lblUsuarioIncorrecto.setFont(new Font("Tahoma", Font.PLAIN, 9));
		this.lblUsuarioIncorrecto.setForeground(Color.RED);
		this.lblUsuarioIncorrecto.setBounds(10, 68, 100, 14);
		this.panel_Nombre.add(this.lblUsuarioIncorrecto);
		
		this.panel_2 = new JPanel();
		this.panelCentral.add(this.panel_2);
		this.panel_2.setLayout(null);
		
		this.lblNewLabel_1 = new JLabel("Contraseña");
		this.lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.lblNewLabel_1.setBounds(27, 40, 70, 17);
		this.panel_2.add(this.lblNewLabel_1);
		
		this.panel_Contrasenia = new JPanel();
		this.panelCentral.add(this.panel_Contrasenia);
		this.panel_Contrasenia.setLayout(null);
		
		this.textField_Contrasenia = new JTextField();
		this.textField_Contrasenia.setBounds(10, 38, 100, 20);
		this.panel_Contrasenia.add(this.textField_Contrasenia);
		this.textField_Contrasenia.setColumns(10);
		
		this.lblPasswordIncorrecto = new JLabel("");
		this.lblPasswordIncorrecto.setFont(new Font("Tahoma", Font.PLAIN, 9));
		this.lblPasswordIncorrecto.setForeground(Color.RED);
		this.lblPasswordIncorrecto.setBounds(10, 62, 100, 13);
		this.panel_Contrasenia.add(this.lblPasswordIncorrecto);
		
		this.lblNewLabel_2 = new JLabel("");
		this.panelCentral.add(this.lblNewLabel_2);
		
		this.panel_1 = new JPanel();
		this.panelCentral.add(this.panel_1);
		
		this.btnIngresar = new JButton("Ingresar");
		this.btnIngresar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		this.panel_1.add(this.btnIngresar);
		
		this.textField_Nombre.setName("textField_Nombre");
		this.btnIngresar.setName("btnIngresar");
		this.lblUsuarioIncorrecto.setName("lblUsuarioIncorrecto");
		this.panel_Nombre.setName("panel_Nombre");
		this.panel_Contrasenia.setName("panel_Contrasenia");
		this.textField_Contrasenia.setName("textField_Contrasenia");
		this.lblPasswordIncorrecto.setName("lblPasswordIncorrecto");
		
		setVisible(true);
	}

		
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnIngresar.addActionListener(listener);
		this.btnIngresar.setActionCommand(INGRESAR);
		
	}

	@Override
	public String getNombreUsuario() {
		return this.textField_Nombre.getText();
	}

	@Override
	public String getPassword() {
		return this.textField_Contrasenia.getText();
	}
	
	public void cerrar() {
		setVisible(false);
		dispose(); //Evita que se haga persistencia cuando no se cerro con la X (no llama al windowsListener)
	}


	@Override
	public void usuarioIncorrecto(String texto) {
		this.lblUsuarioIncorrecto.setText(texto);
	}


	@Override
	public void passwordIncorrecto(String texto) {
		this.lblPasswordIncorrecto.setText(texto);
	}
}