package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tallerDeProgra.capaDeDatos.Producto;
import com.tallerDeProgra.enums.Dias;
import com.tallerDeProgra.enums.VerdaderoFalso;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.JRadioButton;

public class VistaAltaPromocion extends JFrame implements IVista{

	private JPanel contentPane;
	private JTextField textField_CantidadMinima;
	private JComboBox<String> comboBoxAplicadosxuno = new JComboBox<String>();
	private JButton btnAtras = new JButton((Icon) null);
	private JButton btnAgregar = new JButton((Icon) null);
	private JTextField textField_PrecioUnitario;
	private JComboBox <Producto>comboBoxProductos = new JComboBox<Producto>();
	private JRadioButton rdbtnLunes = new JRadioButton("Lunes");
	private JRadioButton rdbtnMartes = new JRadioButton("Martes");
	private JRadioButton rdbtnMiercoles = new JRadioButton("Miercoles");
	private JRadioButton rdbtnJueves = new JRadioButton("Jueves");
	private JRadioButton rdbtnViernes = new JRadioButton("Viernes");
	private JRadioButton rdbtnSabado = new JRadioButton("Sabado");
	private JRadioButton rdbtnDomingo = new JRadioButton("Domingo");
	private JComboBox<String> comboBoxAplicaDescXCant = new JComboBox<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaPromocion frame = new VistaAltaPromocion();
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
	public VistaAltaPromocion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgregarPromocion = new JLabel("<html>Agregar Promocion <html\\>");
		lblAgregarPromocion.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblAgregarPromocion.setBounds(98, 11, 251, 72);
		contentPane.add(lblAgregarPromocion);
		
		JLabel lblNewLabel_1 = new JLabel("Producto:");
		lblNewLabel_1.setBounds(41, 83, 95, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_CantidadMinima = new JTextField();
		textField_CantidadMinima.setColumns(10);
		textField_CantidadMinima.setBounds(114, 386, 86, 20);
		contentPane.add(textField_CantidadMinima);
		
		JLabel lblNewLabel_2 = new JLabel("Dias de promocion:");
		lblNewLabel_2.setBounds(41, 117, 95, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Aplica 2x1:");
		lblNewLabel_4.setBounds(41, 243, 95, 14);
		contentPane.add(lblNewLabel_4);
		
		comboBoxAplicadosxuno.setBounds(114, 261, 86, 18);
		contentPane.add(comboBoxAplicadosxuno);
		
		btnAtras.setText("Atras");
		btnAtras.setBounds(77, 478, 89, 23);
		contentPane.add(btnAtras);
		
		btnAgregar.setText("Agregar");
		btnAgregar.setBounds(221, 478, 89, 23);
		contentPane.add(btnAgregar);
		
		comboBoxProductos.setBounds(121, 83, 217, 22);
		contentPane.add(comboBoxProductos);
		
		rdbtnLunes.setBounds(91, 144, 109, 23);
		contentPane.add(rdbtnLunes);

		rdbtnMartes.setBounds(202, 144, 109, 23);
		contentPane.add(rdbtnMartes);
		
		rdbtnJueves.setBounds(202, 166, 109, 23);
		contentPane.add(rdbtnJueves);
		
		rdbtnMiercoles.setBounds(91, 166, 109, 23);
		contentPane.add(rdbtnMiercoles);
		
		rdbtnSabado.setBounds(202, 186, 109, 23);
		contentPane.add(rdbtnSabado);
		
		rdbtnDomingo.setBounds(91, 205, 109, 23);
		contentPane.add(rdbtnDomingo);
		
		rdbtnViernes.setBounds(91, 186, 109, 23);
		contentPane.add(rdbtnViernes);
		
		JLabel lblNewLabel_4_1 = new JLabel("Aplica descuento por cantidad minima:");
		lblNewLabel_4_1.setBounds(41, 290, 286, 23);
		contentPane.add(lblNewLabel_4_1);
		
		comboBoxAplicaDescXCant.setBounds(114, 321, 86, 18);
		contentPane.add(comboBoxAplicaDescXCant);
		
		JLabel lblNewLabel_4_2 = new JLabel("Cantidad minima para aplicar descuento:");
		lblNewLabel_4_2.setBounds(41, 350, 286, 25);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Precio unitario para descuento por cantidad minima:");
		lblNewLabel_4_2_1.setBounds(41, 417, 334, 19);
		contentPane.add(lblNewLabel_4_2_1);
		
		this.comboBoxAplicaDescXCant.addItem(VerdaderoFalso.VERDADERO.getTexto());
		this.comboBoxAplicaDescXCant.addItem(VerdaderoFalso.FALSO.getTexto());
		this.comboBoxAplicadosxuno.addItem(VerdaderoFalso.VERDADERO.getTexto());
		this.comboBoxAplicadosxuno.addItem(VerdaderoFalso.FALSO.getTexto());
		
		textField_PrecioUnitario = new JTextField();
		textField_PrecioUnitario.setColumns(10);
		textField_PrecioUnitario.setBounds(114, 447, 86, 20);
		contentPane.add(textField_PrecioUnitario);
		this.setVisible(true);
	}
	
	
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnAgregar.setActionCommand(AGREGAR_PROMOCION);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(CANCELAR_PROMOCION);
		
	}
	public void actualizaComboBoxProductos(ArrayList<Producto> productos) {
		this.comboBoxProductos.removeAllItems();
		for(Producto i: productos)
			comboBoxProductos.addItem(i);
	}
	
	public Producto getProducto() {
		return (Producto) this.comboBoxProductos.getSelectedItem();
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
	
	public boolean getAplicaDosporuno() {
		if(this.comboBoxAplicadosxuno.getSelectedItem().equals(VerdaderoFalso.VERDADERO.getTexto()))
			return true;
		else
			return false;
	}

	public boolean getAplicaDescCantidadMinima() {
		if(this.comboBoxAplicaDescXCant.getSelectedItem().equals(VerdaderoFalso.VERDADERO.getTexto()))
			return true;
		else
			return false;
	}
	public String getCantidadMinima() {
		return this.textField_CantidadMinima.getText();
	}
	public String getPrecioUnitario() {
		return this.textField_PrecioUnitario.getText();
	}

	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}
}
