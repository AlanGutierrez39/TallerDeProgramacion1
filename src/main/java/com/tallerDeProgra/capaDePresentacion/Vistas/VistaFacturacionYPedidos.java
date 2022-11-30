package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.tallerDeProgra.capaDeDatos.Comanda;
import com.tallerDeProgra.capaDeDatos.Mozo;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaFacturacionYPedidos extends JFrame implements IVista{

	private JPanel contentPane;
	private JLabel lblNewLabel = new JLabel("Seleccionar comanda:");
	private JComboBox comboBoxComandas = new JComboBox();
	private JButton btnConfeccionarComanda = new JButton("Confeccionar comanda");
	private JButton btnAgregarPedido = new JButton("Agregar pedido");
	private JButton btnCerrarComanda = new JButton("Cerrar comanda");
	private JButton btnAtras = new JButton("Atras");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaFacturacionYPedidos frame = new VistaFacturacionYPedidos();
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
	public VistaFacturacionYPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 24, 299, 14);
		contentPane.add(lblNewLabel);
		
		comboBoxComandas.setBounds(44, 78, 199, 28);
		contentPane.add(comboBoxComandas);
		
		btnConfeccionarComanda.setBounds(27, 276, 169, 23);
		contentPane.add(btnConfeccionarComanda);
		btnAgregarPedido.setBounds(243, 276, 152, 23);
		contentPane.add(btnAgregarPedido);
		
		btnCerrarComanda.setBounds(243, 332, 152, 23);
		contentPane.add(btnCerrarComanda);
		btnAtras.setBounds(306, 400, 89, 23);
		this.btnAgregarPedido.setName("btnAgregarPedido");
		this.btnAtras.setName("btnAtras");
		this.btnCerrarComanda.setName("btnCerrarComanda");
		this.btnConfeccionarComanda.setName("btnConfeccionarComanda");
		this.comboBoxComandas.setName("comboBoxComandas");
		contentPane.add(btnAtras);
		this.setVisible(true);
	}

	
	public void actualizaComboBoxComandas(ArrayList<Comanda> comandas) {
		this.comboBoxComandas.removeAllItems();
		
		for(Comanda i: comandas)
			comboBoxComandas.addItem(i);
	}
	
	public Comanda getComanda() {
		return (Comanda) this.comboBoxComandas.getSelectedItem();
	}
	
	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregarPedido.addActionListener(listener);
		this.btnAgregarPedido.setActionCommand(AGREGAR_PEDIDO);
		this.btnCerrarComanda.addActionListener(listener);
		this.btnCerrarComanda.setActionCommand(CERRAR_COMANDA);
		this.btnConfeccionarComanda.addActionListener(listener);
		this.btnConfeccionarComanda.setActionCommand(CREAR_COMANDA);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(ATRAS_COMANDA);
		this.comboBoxComandas.addActionListener(listener);
		this.comboBoxComandas.setActionCommand(MODIFICACION_LISTA_PRODUCTOS);
	}
	
	
	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}

	
	public void habilitarPedido(boolean boleano) {
		this.btnAgregarPedido.setEnabled(boleano);
		
	}
	
	public void habilitarCerrarComanda(boolean boleano) {
		this.btnCerrarComanda.setEnabled(boleano);
		
	}
	
}
