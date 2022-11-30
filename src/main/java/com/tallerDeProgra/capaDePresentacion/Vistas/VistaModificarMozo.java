package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.enums.Estado;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

public class VistaModificarMozo extends JFrame implements IVista{
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldNombreYApel;
	private JLabel lblNewLabel_2;
	private JTextField textFieldDiaNac;
	private JTextField textFieldMesNac;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField textFieldAnioNac;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTextField textFieldCantHijos;
	private JLabel lblNewLabel_7;
	private JTextField textFieldSueldo;
	private JLabel lblNewLabel_8;
	private JComboBox comboBoxEstado;
	private JLabel lblError;
	private JButton btnCancelar;
	private JButton btnConfirmar;

	/**
	 * Create the frame.
	 */
	public VistaModificarMozo() {
		setTitle("Modificar mozo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 237, 339);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblNewLabel = new JLabel("Modicar mozo");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel.setBounds(47, 11, 127, 25);
		this.contentPane.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("Nombre y apellido");
		this.lblNewLabel_1.setBounds(10, 47, 110, 14);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.textFieldNombreYApel = new JTextField();
		this.textFieldNombreYApel.setColumns(10);
		this.textFieldNombreYApel.setBounds(113, 45, 104, 17);
		this.contentPane.add(this.textFieldNombreYApel);
		
		this.lblNewLabel_2 = new JLabel("Fecha nacimiento");
		this.lblNewLabel_2.setBounds(10, 88, 93, 14);
		this.contentPane.add(this.lblNewLabel_2);
		
		this.textFieldDiaNac = new JTextField();
		this.textFieldDiaNac.setColumns(10);
		this.textFieldDiaNac.setBounds(122, 86, 19, 16);
		this.contentPane.add(this.textFieldDiaNac);
		
		this.textFieldMesNac = new JTextField();
		this.textFieldMesNac.setColumns(10);
		this.textFieldMesNac.setBounds(151, 86, 19, 17);
		this.contentPane.add(this.textFieldMesNac);
		
		this.lblNewLabel_3 = new JLabel("/");
		this.lblNewLabel_3.setBounds(173, 88, 11, 14);
		this.contentPane.add(this.lblNewLabel_3);
		
		this.lblNewLabel_4 = new JLabel("/");
		this.lblNewLabel_4.setBounds(143, 88, 4, 14);
		this.contentPane.add(this.lblNewLabel_4);
		
		this.textFieldAnioNac = new JTextField();
		this.textFieldAnioNac.setColumns(10);
		this.textFieldAnioNac.setBounds(180, 86, 34, 17);
		this.contentPane.add(this.textFieldAnioNac);
		
		this.lblNewLabel_5 = new JLabel("dd/MM/yyyy");
		this.lblNewLabel_5.setBounds(132, 101, 70, 18);
		this.contentPane.add(this.lblNewLabel_5);
		
		this.lblNewLabel_6 = new JLabel("Cantidad hijos");
		this.lblNewLabel_6.setBounds(10, 133, 93, 14);
		this.contentPane.add(this.lblNewLabel_6);
		
		this.textFieldCantHijos = new JTextField();
		this.textFieldCantHijos.setColumns(10);
		this.textFieldCantHijos.setBounds(113, 131, 49, 17);
		this.contentPane.add(this.textFieldCantHijos);
		
		this.lblNewLabel_7 = new JLabel("Sueldo");
		this.lblNewLabel_7.setBounds(10, 176, 46, 14);
		this.contentPane.add(this.lblNewLabel_7);
		
		this.textFieldSueldo = new JTextField();
		this.textFieldSueldo.setColumns(10);
		this.textFieldSueldo.setBounds(113, 174, 104, 17);
		this.contentPane.add(this.textFieldSueldo);
		
		this.lblNewLabel_8 = new JLabel("Estado");
		this.lblNewLabel_8.setBounds(10, 218, 46, 14);
		this.contentPane.add(this.lblNewLabel_8);
		
		this.comboBoxEstado = new JComboBox();
		this.comboBoxEstado.setBounds(113, 214, 104, 22);
		this.contentPane.add(this.comboBoxEstado);
		this.comboBoxEstado.addItem((String) Estado.ACTIVO.getEstado());
		this.comboBoxEstado.addItem((String) Estado.AUSENTE.getEstado());
		this.comboBoxEstado.addItem((String) Estado.DE_FRANCO.getEstado());
		
		this.lblError = new JLabel("");
		this.lblError.setForeground(Color.RED);
		this.lblError.setBounds(20, 240, 197, 14);
		this.contentPane.add(this.lblError);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(10, 265, 89, 23);
		this.contentPane.add(this.btnCancelar);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(113, 265, 89, 23);
		this.contentPane.add(this.btnConfirmar);
		
		setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnCancelar.addActionListener(listener);
		this.btnCancelar.setActionCommand(IVista.CANCELAR_MOZO);
		this.btnConfirmar.addActionListener(listener);
		this.btnConfirmar.setActionCommand(IVista.CONFIRMAR_MOZO);
	}

	@Override
	public void cerrar() {
		setVisible(false);
	}

	public String getNombreYApel() {
		return this.textFieldNombreYApel.getText();
	}
	public String getDiaNac() {
		return this.textFieldDiaNac.getText();
	}
	public String getMesNac() {
		return this.textFieldMesNac.getText();
	}
	public String getAnioNac() {
		return this.textFieldAnioNac.getText();
	}
	public String getCantHijos() {
		return this.textFieldCantHijos.getText();
	}
	public String getSueldo() {
		return this.textFieldSueldo.getText();
	}
	public String getEstado() {
		return this.comboBoxEstado.getSelectedItem().toString();
	}
	public void setLblError(String msg) {
		this.lblError.setText(msg);
	}
	
	public void setCampos(Mozo mozo) {
		this.textFieldAnioNac.setText(String.valueOf(mozo.getNacimiento().getYear()));
		this.textFieldMesNac.setText(String.valueOf(mozo.getNacimiento().getMonth()));
		this.textFieldDiaNac.setText(String.valueOf(mozo.getNacimiento().getDay()));
		this.textFieldCantHijos.setText(String.valueOf(mozo.getCantHijos()));
		this.textFieldNombreYApel.setText(mozo.getNombreYApellido());
		this.textFieldSueldo.setText(String.valueOf(mozo.getSueldo()));
	}
}
