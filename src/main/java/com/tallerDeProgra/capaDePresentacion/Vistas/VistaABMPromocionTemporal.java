package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.Promocion;
import com.tallerDeProgra.capaDeDatos.PromocionTemporal;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class VistaABMPromocionTemporal extends JFrame implements IVista {

	private JPanel contentPane;

	private JButton btnAgregar = new JButton("Agregar");
	private JButton btnEliminar_1 = new JButton("Eliminar");
	private JButton btnAtras_1 = new JButton("Atras");
	private JComboBox<PromocionTemporal> comboBoxPromocionTemporal = new JComboBox<PromocionTemporal>();
	private final JLabel lblPromocionesTemporales = new JLabel("Promociones temporales");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaABMPromocionTemporal frame = new VistaABMPromocionTemporal();
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
	public VistaABMPromocionTemporal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		comboBoxPromocionTemporal.setBounds(96, 63, 246, 23);
		contentPane.add(comboBoxPromocionTemporal);
		
		btnAgregar.setBounds(112, 129, 89, 23);
		contentPane.add(btnAgregar);
		
		btnEliminar_1.setBounds(229, 129, 89, 23);
		contentPane.add(btnEliminar_1);
		
		btnAtras_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtras_1.setBounds(276, 204, 66, 22);
		contentPane.add(btnAtras_1);
		lblPromocionesTemporales.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPromocionesTemporales.setBounds(125, 7, 211, 23);
		
		contentPane.add(lblPromocionesTemporales);
		this.setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnAgregar.setActionCommand(AGREGAR_PROMOCION_TEMPORAL);
		this.btnAtras_1.addActionListener(listener);
		this.btnAtras_1.setActionCommand(SALIR_DE_PROMOCION_TEMPORAL);
		this.btnEliminar_1.addActionListener(listener);
		this.btnEliminar_1.setActionCommand(ELIMINAR_PROMOCION_TEMPORAL);
		
	}

	
	public void actualizaComboBoxPromocionTemporal(ArrayList<PromocionTemporal> promocion) {
		this.comboBoxPromocionTemporal.removeAllItems();
		for(PromocionTemporal i: promocion)
			comboBoxPromocionTemporal.addItem(i);
	}
	public PromocionTemporal getPromocionTemporal() {
		return (PromocionTemporal) this.comboBoxPromocionTemporal.getSelectedItem();
	}
	
	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}

}
