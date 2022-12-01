package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Mesa;
import capaDeDatos.Mesa;
import capaDeDatos.Producto;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VistaAltaComanda extends JFrame implements IVista {

	private JPanel contentPane;
	private JComboBox<Mesa> comboBoxMesas = new JComboBox<Mesa>();
	private JButton btnSiguiente = new JButton("Siguiente");
	private JButton btnAtras = new JButton("Atras");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAltaComanda frame = new VistaAltaComanda();
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
	public VistaAltaComanda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		comboBoxMesas.setBounds(65, 86, 225, 22);
		contentPane.add(comboBoxMesas);
		
		JLabel lblNewLabel = new JLabel("Crear comanda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(129, 11, 203, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccionar mesa:");
		lblNewLabel_1.setBounds(32, 58, 193, 14);
		contentPane.add(lblNewLabel_1);
		
		btnSiguiente.setBounds(308, 206, 89, 23);
		contentPane.add(btnSiguiente);
		
		btnAtras.setBounds(32, 206, 89, 23);
		contentPane.add(btnAtras);
		setLocationRelativeTo(null);
		
		this.setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnSiguiente.addActionListener(listener);
		this.btnSiguiente.setActionCommand(SIGUIENTE_COMANDA);
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(ATRAS_SIGUIENTE_COMANDA);
		
	}

	public void actualizaComboBoxMesas(ArrayList<Mesa> mesas) {
		this.comboBoxMesas.removeAllItems();
		for(Mesa i: mesas)
			this.comboBoxMesas.addItem(i);
	}
	
	public Mesa getMesa() {
		return (Mesa) this.comboBoxMesas.getSelectedItem();
	}
	@Override
	public void cerrar() {
		this.setVisible(false);
		
	}

}
