package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Mozo;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VistaEstadisticas extends JFrame implements IVista{

	private JPanel contentPane;
	private JComboBox<Mozo> comboBoxMozos = new JComboBox<Mozo>();
	private JLabel lblPromedio = new JLabel("Consumo promedio por mesa para el empleado seleccionado:");
	private JLabel lblMayor = new JLabel("Empleado con mayor volumen de venta:");
	private JLabel lblRespuestaMayor = new JLabel("New label");
	private JLabel lblRespuestaMenor = new JLabel("New label");
	private JLabel lblRespuestaPromedio = new JLabel("New label");
	private JButton btnAtras = new JButton("Atras");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEstadisticas frame = new VistaEstadisticas();
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
	public VistaEstadisticas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		comboBoxMozos.setBounds(27, 11, 217, 34);
		contentPane.add(comboBoxMozos);
		
		lblPromedio.setBounds(27, 119, 344, 34);
		contentPane.add(lblPromedio);
		
		lblMayor.setBounds(27, 184, 344, 14);
		contentPane.add(lblMayor);
		
		lblRespuestaMayor.setBounds(403, 184, 151, 14);
		contentPane.add(lblRespuestaMayor);
		
		JLabel lblMenor = new JLabel("Empleado con menor volumen de venta:");
		lblMenor.setBounds(27, 234, 344, 14);
		contentPane.add(lblMenor);
		
		lblRespuestaMenor.setBounds(403, 234, 151, 14);
		contentPane.add(lblRespuestaMenor);
		
		lblRespuestaPromedio.setBounds(403, 129, 151, 14);
		contentPane.add(lblRespuestaPromedio);
		
		btnAtras.setBounds(428, 296, 89, 23);
		contentPane.add(btnAtras);
		this.setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.comboBoxMozos.addActionListener(listener);
		this.comboBoxMozos.setActionCommand(MODIFICACION_LISTA_ESTADISTICA);;
		this.btnAtras.addActionListener(listener);
		this.btnAtras.setActionCommand(ATRAS_ESTADISTICAS);
	}
	
	public void actualizaComboBoxOperarios(ArrayList<Mozo> mozos) {
		this.comboBoxMozos.removeAllItems();
		for(Mozo i: mozos)
			comboBoxMozos.addItem(i);
	}
	public Mozo getMozo() {
		return (Mozo) this.comboBoxMozos.getSelectedItem();
	}
	
	public void setLabelPromedio(String texto) {
		this.lblRespuestaPromedio.setText(texto);
	}
	
	public void setLabelMayor(String texto) {
		this.lblRespuestaMayor.setText(texto);
	}
	
	public void setLabelMenor(String texto) {
		this.lblRespuestaMenor.setText(texto);
	}
	
	@Override
	public void cerrar() {
		setVisible(false);
		
	}
}
