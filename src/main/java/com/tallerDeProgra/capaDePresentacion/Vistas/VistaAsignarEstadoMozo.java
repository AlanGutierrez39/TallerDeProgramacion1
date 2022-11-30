package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tallerDeProgra.capaDeDatos.Mozo;
import com.tallerDeProgra.capaDeDatos.Operario;
import com.tallerDeProgra.capaDeDatos.OperarioAdministrador;
import com.tallerDeProgra.enums.Estado;

import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import java.awt.Color;

public class VistaAsignarEstadoMozo extends JFrame implements IVista{
	private JPanel contentPane;
	private JPanel panel;
	private JComboBox<Mozo> comboBoxMozos;
	private JButton btnGuardarEstado;
	private JButton btnAtras;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnAusente = new JRadioButton(Estado.AUSENTE.getEstado());
	private JRadioButton rdbtnPresente = new JRadioButton(Estado.ACTIVO.getEstado());
	private JRadioButton rdbtnDeFranco = new JRadioButton(Estado.DE_FRANCO.getEstado());
	private JLabel lblNewLabel_1;
	private JLabel lblActivo = new JLabel("<html>Activos:  Presentes:  Ausentes: <html\\>");
	private JLabel lblException = new JLabel("<html>Ya existen mas de 2 empleados de franco, debe cambiar un empleado de franco a otro estado<html\\>");
	
	/**
	 * Create the frame.
	 */
	public VistaAsignarEstadoMozo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 356);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		setLocationRelativeTo(null);
		this.panel = new JPanel();
		this.contentPane.add(this.panel, BorderLayout.CENTER);
		this.panel.setLayout(null);
		
//		-------------------------------------------------------
		this.comboBoxMozos = new JComboBox<Mozo>();				
		this.comboBoxMozos.setBounds(28, 34, 246, 23);
		this.panel.add(this.comboBoxMozos);
		
		this.btnGuardarEstado = new JButton("Guardar estado");
		btnGuardarEstado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		this.btnGuardarEstado.setBounds(112, 189, 134, 35);
		this.panel.add(this.btnGuardarEstado);
		
		this.btnAtras = new JButton("Atras");
		this.btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 11));
		this.btnAtras.setBounds(290, 262, 66, 22);
		this.panel.add(this.btnAtras);
		
		buttonGroup.add(rdbtnAusente);
		rdbtnAusente.setBounds(138, 107, 109, 23);
		panel.add(rdbtnAusente);
		this.rdbtnAusente.setSelected(true);
		
		buttonGroup.add(rdbtnPresente);
		rdbtnPresente.setBounds(138, 133, 109, 23);
		panel.add(rdbtnPresente);
		
		buttonGroup.add(rdbtnDeFranco);
		rdbtnDeFranco.setBounds(138, 159, 109, 23);
		panel.add(rdbtnDeFranco);
		
		JLabel lblNewLabel = new JLabel("Cambiar estado a:");
		lblNewLabel.setBounds(28, 89, 89, 12);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Seleccionar mozo");
		lblNewLabel_1.setBounds(10, 9, 109, 14);
		panel.add(lblNewLabel_1);
		
		lblActivo.setBounds(263, 91, 93, 65);
		panel.add(lblActivo);
		
		
		lblException.setForeground(Color.RED);
		lblException.setBounds(28, 235, 224, 61);
		panel.add(lblException);
		lblException.setVisible(false);
		setVisible(true);
	}

	
	public void actualizaComboBoxOperarios(ArrayList<Mozo> mozos) {
		this.comboBoxMozos.removeAllItems();
		for(Mozo i: mozos)
			comboBoxMozos.addItem(i);
	}
	
	public Mozo getMozo() {
		return (Mozo) this.comboBoxMozos.getSelectedItem();
	}
	
	public String getEstado() {
		String aux = null;
		if(this.rdbtnAusente.isSelected()){
			aux= Estado.AUSENTE.getEstado();
		}
		if(this.rdbtnDeFranco.isSelected()){
			aux= Estado.DE_FRANCO.getEstado();
		}
		if(this.rdbtnPresente.isSelected()){
			aux=Estado.ACTIVO.getEstado();
		}
		return aux;
	}
	
	public void cerrar() {
		setVisible(false);
	}
	
	
	@Override
	public void addActionListener(ActionListener listener) {
		this.rdbtnDeFranco.addActionListener(listener);
		this.rdbtnPresente.addActionListener(listener);
		this.rdbtnAusente.addActionListener(listener);
		
		this.btnGuardarEstado.addActionListener(listener);
		this.btnGuardarEstado.setActionCommand(GUARDAR_ESTADO_MOZO);;
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(ATRAS_ESTADO_MOZO);;
	}

	@Override
	public void addWindowListener(WindowListener windowListener) {
		// TODO Auto-generated method stub
		
	}
}
