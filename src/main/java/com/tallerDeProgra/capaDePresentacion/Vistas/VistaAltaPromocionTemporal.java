package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tallerDeProgra.enums.Dias;
import com.tallerDeProgra.enums.FormaDePago;
import com.tallerDeProgra.enums.VerdaderoFalso;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.JRadioButton;

public class VistaAltaPromocionTemporal extends JFrame implements IVista{

	private JPanel contentPane;
	private JButton btnAgregar = new JButton((Icon) null);
	private JButton btnAtras = new JButton((Icon) null);
	private JTextField textFieldDescuento;
	private JTextField textField_nombre;
	private JRadioButton rdbtnLunes = new JRadioButton("Lunes");
	private JRadioButton rdbtnMartes = new JRadioButton("Martes");
	private JRadioButton rdbtnMiercoles = new JRadioButton("Miercoles");
	private JRadioButton rdbtnJueves = new JRadioButton("Jueves");
	private JRadioButton rdbtnViernes = new JRadioButton("Viernes");
	private JRadioButton rdbtnSabado = new JRadioButton("Sabado");
	private JRadioButton rdbtnDomingo = new JRadioButton("Domingo");
	private JComboBox<String> comboBoxMedioDePago = new JComboBox<String>();
	private JComboBox<String> comboBoxEsAcumulable = new JComboBox<String>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaPromocionTemporal frame = new VistaAltaPromocionTemporal();
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
	public VistaAltaPromocionTemporal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarPromocion = new JLabel("<html>Agregar Promocion temporal<html\\>");
		lblAgregarPromocion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAgregarPromocion.setBounds(110, 0, 203, 66);
		contentPane.add(lblAgregarPromocion);
		
		btnAtras.setText("Atras");
		btnAtras.setBounds(80, 394, 89, 23);
		contentPane.add(btnAtras);
		
		btnAgregar.setText("Agregar");
		btnAgregar.setBounds(224, 394, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblNewLabel_2 = new JLabel("Dias de promocion:");
		lblNewLabel_2.setBounds(40, 227, 95, 20);
		contentPane.add(lblNewLabel_2);
		
		rdbtnLunes.setBounds(90, 254, 109, 23);
		contentPane.add(rdbtnLunes);
		
		rdbtnMiercoles.setBounds(90, 276, 109, 23);
		contentPane.add(rdbtnMiercoles);
		
		rdbtnViernes.setBounds(90, 296, 109, 23);
		contentPane.add(rdbtnViernes);
		
		rdbtnDomingo.setBounds(90, 315, 109, 23);
		contentPane.add(rdbtnDomingo);
		
		rdbtnMartes.setBounds(201, 254, 109, 23);
		contentPane.add(rdbtnMartes);
		
		rdbtnJueves.setBounds(201, 276, 109, 23);
		contentPane.add(rdbtnJueves);
		
		rdbtnSabado.setBounds(201, 296, 109, 23);
		contentPane.add(rdbtnSabado);
		
		JLabel lblNewLabel_4_2 = new JLabel("Porcentaje de descuento(sin %):");
		lblNewLabel_4_2.setBounds(39, 167, 286, 25);
		contentPane.add(lblNewLabel_4_2);
		
		textFieldDescuento = new JTextField();
		textFieldDescuento.setColumns(10);
		textFieldDescuento.setBounds(141, 192, 86, 20);
		contentPane.add(textFieldDescuento);
		
		comboBoxEsAcumulable.setBounds(129, 360, 86, 18);
		contentPane.add(comboBoxEsAcumulable);
		
		JLabel lblNewLabel_4_1 = new JLabel("Es acumulable?");
		lblNewLabel_4_1.setBounds(39, 339, 286, 23);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Nombre de la promocion:");
		lblNewLabel_4_1_1.setBounds(40, 62, 286, 23);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Forma de pago:");
		lblNewLabel_4_2_1.setBounds(40, 114, 286, 25);
		contentPane.add(lblNewLabel_4_2_1);
		
		comboBoxMedioDePago.setBounds(141, 138, 86, 18);
		contentPane.add(comboBoxMedioDePago);
		
		
		this.comboBoxMedioDePago.addItem(FormaDePago.CUENTADNI.getText());
		this.comboBoxMedioDePago.addItem(FormaDePago.EFECTIVO.getText());
		this.comboBoxMedioDePago.addItem(FormaDePago.MERCPAGO.getText());
		this.comboBoxMedioDePago.addItem(FormaDePago.TARJETA.getText());
		

		this.comboBoxEsAcumulable.addItem(VerdaderoFalso.VERDADERO.getTexto());
		this.comboBoxEsAcumulable.addItem(VerdaderoFalso.FALSO.getTexto());
		
		textField_nombre = new JTextField();
		textField_nombre.setColumns(10);
		textField_nombre.setBounds(91, 83, 187, 20);
		contentPane.add(textField_nombre);
		this.setVisible(true);
	}

	
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnAgregar.setActionCommand(AGREGAR_PROMOCION_TEMPORAL);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(CANCELAR_PROMOCION_TEMPORAL);
		
	}
	
	public String getNombre() {
		return this.textField_nombre.getText();
	}
	
	public String getFormaDePago() {
		return (String)this.comboBoxMedioDePago.getSelectedItem();
	}
	
	public String getPorcentajeDescuento() {
		return this.textFieldDescuento.getText();
	}
	
	
	public ArrayList<String> getDiasDePromo() {
		ArrayList <String> dias=new ArrayList<String>();
		if(this.rdbtnLunes.isSelected())
			dias.add(Dias.LUNES.getDia());
		if(this.rdbtnMartes.isSelected())
			dias.add(Dias.MARTES.getDia());
		if(this.rdbtnMiercoles.isSelected())
			dias.add(Dias.MIERCOLES.getDia());
		if(this.rdbtnJueves.isSelected())
			dias.add(Dias.JUEVES.getDia());
		if(this.rdbtnViernes.isSelected())
			dias.add(Dias.VIERNES.getDia());
		if(this.rdbtnSabado.isSelected())
			dias.add(Dias.SABADO.getDia());
		if(this.rdbtnDomingo.isSelected())
			dias.add(Dias.DOMINGO.getDia());
		return dias;
	}
	
	public boolean getEsAcumulable() {
		if(this.comboBoxEsAcumulable.getSelectedItem().equals(VerdaderoFalso.VERDADERO.getTexto()))
			return true;
		else
			return false;
	}
	
	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}

}
