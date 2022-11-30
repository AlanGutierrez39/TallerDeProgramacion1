package com.tallerDeProgra.capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;

public class VistaMenuOperarioAdministrador extends JFrame implements IVista{

	private JPanel contentPane;
	private JPanel panelBotones = new JPanel();
	private JButton btnMenuMozos = new JButton("Mozos");
	private JButton btnArrancarDia = new JButton("Dar inicio al dia");
	private JButton btnAsignarMozosA = new JButton("Cambiar estado de los mozos");
	private JButton btnVerificarEstadisticas = new JButton("Verificar estadisticas");
	private JButton btnConfigurarEmpresa = new JButton("Configurar empresa");
	private JButton btnOperarios = new JButton("Operarios");
	private JButton btnMesas = new JButton("Mesas");
	private JButton btnProducto = new JButton("Producto");
	private JButton btnPromocion = new JButton("Promocion");
	private JButton btnPromocionTemporal = new JButton("Promocion temporal");
	private JLabel lblNewLabel = new JLabel("Menu operario administrador");
	private JButton btnSalir = new JButton("Salir");
	private final JButton btnFacturacion = new JButton("Facturacion y pedidos");
	private final JLabel lblExcepcionInicioDia = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaMenuOperarioAdministrador frame = new VistaMenuOperarioAdministrador();
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
	public VistaMenuOperarioAdministrador() {
		setTitle("Menu Operario Administrador");
		setPreferredSize(new Dimension(800, 800));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 701);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		contentPane.add(panelBotones);
		panelBotones.setLayout(null);
		
		btnMenuMozos.setBounds(117, 74, 191, 30);
		panelBotones.add(btnMenuMozos);
		btnArrancarDia.setBackground(new Color(128, 0, 0));
		btnArrancarDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnArrancarDia.setBounds(75, 544, 271, 49);
		panelBotones.add(btnArrancarDia);
		
		btnAsignarMozosA.setBounds(117, 115, 191, 30);
		panelBotones.add(btnAsignarMozosA);
		
		btnVerificarEstadisticas.setBounds(117, 156, 191, 30);
		panelBotones.add(btnVerificarEstadisticas);
		
		btnConfigurarEmpresa.setBounds(117, 197, 191, 30);
		panelBotones.add(btnConfigurarEmpresa);
		
		btnOperarios.setBounds(117, 238, 191, 30);
		panelBotones.add(btnOperarios);
		
		btnMesas.setBounds(117, 279, 191, 30);
		panelBotones.add(btnMesas);
		
		btnProducto.setBounds(117, 320, 191, 30);
		panelBotones.add(btnProducto);
		
		btnPromocion.setBounds(117, 361, 191, 30);
		panelBotones.add(btnPromocion);
		
		btnPromocionTemporal.setBounds(117, 402, 191, 30);
		panelBotones.add(btnPromocionTemporal);
		
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(92, 10, 242, 35);
		panelBotones.add(lblNewLabel);
		
		btnSalir.setBounds(344, 15, 76, 30);
		panelBotones.add(btnSalir);
		btnFacturacion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFacturacion.setVisible(false);
		btnFacturacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFacturacion.setBounds(117, 443, 190, 49);
		
		panelBotones.add(btnFacturacion);
		lblExcepcionInicioDia.setForeground(new Color(255, 0, 0));
		lblExcepcionInicioDia.setBounds(85, 604, 261, 37);
		lblExcepcionInicioDia.setVisible(false);
		panelBotones.add(lblExcepcionInicioDia);
		this.btnArrancarDia.setName("btnArrancarDia");
		this.btnAsignarMozosA.setName("btnAsignarMozosA");
		this.btnConfigurarEmpresa.setName("btnConfigurarEmpresa");
		this.btnFacturacion.setName("btnFacturacion");
		this.btnMenuMozos.setName("btnMenuMozos");
		this.btnMesas.setName("btnMesas");
		this.btnOperarios.setName("btnOperarios");
		this.btnProducto.setName("btnProducto");
		this.btnPromocion.setName("btnPromocion");
		this.btnPromocionTemporal.setName("btnPromocionTemporal");
		this.btnSalir.setName("btnSalir");
		this.btnVerificarEstadisticas.setName("btnVerificarEstadisticas");
		this.setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnArrancarDia.addActionListener(listener);
		this.btnArrancarDia.setActionCommand(ARRANCAR_DIA);
		this.btnAsignarMozosA.addActionListener(listener);
		this.btnAsignarMozosA.setActionCommand(ASIGNAR_MOZO);
		this.btnConfigurarEmpresa.addActionListener(listener);
		this.btnConfigurarEmpresa.setActionCommand(CONFIGURAR_EMPRESA);
		this.btnMenuMozos.addActionListener(listener);
		this.btnMenuMozos.setActionCommand(MOZOS);
		this.btnMesas.addActionListener(listener);
		this.btnMesas.setActionCommand(MESAS);
		this.btnOperarios.addActionListener(listener);
		this.btnOperarios.setActionCommand(OPERARIOS);
		this.btnProducto.addActionListener(listener);
		this.btnProducto.setActionCommand(PRODUCTO);
		this.btnPromocion.addActionListener(listener);
		this.btnPromocion.setActionCommand(PROMOCION);
		this.btnPromocionTemporal.addActionListener(listener);
		this.btnPromocionTemporal.setActionCommand(PROMOCION_TEMPORAL);
		this.btnVerificarEstadisticas.addActionListener(listener);
		this.btnVerificarEstadisticas.setActionCommand(VERIFICAR_ESTADISTICAS);
		this.btnSalir.addActionListener(listener);
		this.btnSalir.setActionCommand(SALIR);
		this.btnFacturacion.addActionListener(listener);
		this.btnFacturacion.setActionCommand(FACTURACION);
	}

	public void habilitarFacturacion() {
		this.btnFacturacion.setVisible(true);
	}
	public void lanzarExcepcionInicioDia(String mensaje) {
		this.lblExcepcionInicioDia.setText("<html>"+mensaje+"<html>");
		this.lblExcepcionInicioDia.setVisible(true);
	}
	
	@Override
	public void cerrar() {
		setVisible(false);
		dispose(); //Evita que se haga persistencia cuando no se cerro con la X (no llama al windowsListener)
	}
}
