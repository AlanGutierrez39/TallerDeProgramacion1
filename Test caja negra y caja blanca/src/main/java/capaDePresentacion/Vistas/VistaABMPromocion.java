package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import capaDeDatos.Operario;
import capaDeDatos.Producto;
import capaDeDatos.Promocion;

import java.awt.Font;
import javax.swing.JLabel;

public class VistaABMPromocion extends JFrame implements IVista{

	private JPanel contentPane;

	private JButton btnEliminar_1 = new JButton("Eliminar");
	private JButton btnAgregar = new JButton("Agregar");
	private JComboBox<Promocion> comboBoxPromocion = new JComboBox<Promocion>();
	private JButton btnAtras_1 = new JButton("Atras");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaABMPromocion frame = new VistaABMPromocion();
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
	public VistaABMPromocion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnEliminar_1.setBounds(228, 120, 89, 23);
		contentPane.add(btnEliminar_1);
		
		btnAgregar.setBounds(111, 120, 89, 23);
		contentPane.add(btnAgregar);
		
		comboBoxPromocion.setBounds(95, 63, 246, 23);
		contentPane.add(comboBoxPromocion);
		
		btnAtras_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAtras_1.setBounds(275, 195, 66, 22);
		contentPane.add(btnAtras_1);
		
		JLabel lblNewLabel = new JLabel("Promociones");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(162, 11, 211, 23);
		contentPane.add(lblNewLabel);
		this.setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnAgregar.addActionListener(listener);
		this.btnAgregar.setActionCommand(AGREGAR_PROMOCION);
		this.btnAtras_1.addActionListener(listener);
		this.btnAtras_1.setActionCommand(SALIR_DE_PROMOCION);
		this.btnEliminar_1.addActionListener(listener);
		this.btnEliminar_1.setActionCommand(ELIMINAR_PROMOCION);
	}
	public void actualizaComboBoxPromocion(ArrayList<Promocion> promocion) {
		this.comboBoxPromocion.removeAllItems();
		for(Promocion i: promocion)
			comboBoxPromocion.addItem(i);
	}
	public Promocion getPromocion() {
		return (Promocion) this.comboBoxPromocion.getSelectedItem();
	}
	
	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}
}
