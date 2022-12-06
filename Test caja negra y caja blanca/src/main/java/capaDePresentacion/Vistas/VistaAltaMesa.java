package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import enums.Estado;
import enums.EstadosMesa;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class VistaAltaMesa extends JFrame implements IVista{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField textFieldCantComensales;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxEstados;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel lblNewLabel_2;
	private JLabel lblError;

	/**
	 * Create the frame.
	 */
	public VistaAltaMesa() {
		setTitle("Alta mesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 257);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		this.lblNewLabel = new JLabel("Cantidad comensales");
		this.lblNewLabel.setBounds(25, 64, 112, 14);
		this.contentPane.add(this.lblNewLabel);
		
		this.textFieldCantComensales = new JTextField();
		this.textFieldCantComensales.setBounds(147, 61, 86, 20);
		this.contentPane.add(this.textFieldCantComensales);
		this.textFieldCantComensales.setColumns(10);
		
		this.lblNewLabel_1 = new JLabel("Estado mesa");
		this.lblNewLabel_1.setBounds(25, 108, 86, 14);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.comboBoxEstados = new JComboBox<String>();
		this.comboBoxEstados.setBounds(147, 104, 86, 20);
		this.contentPane.add(this.comboBoxEstados);
		this.comboBoxEstados.addItem((String) EstadosMesa.LIBRE.getEstado());
		this.comboBoxEstados.addItem((String) EstadosMesa.OCUPADA.getEstado());
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(38, 159, 89, 23);
		this.contentPane.add(this.btnCancelar);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(144, 159, 89, 23);
		this.contentPane.add(this.btnConfirmar);
		
		this.lblNewLabel_2 = new JLabel("Alta mesa");
		this.lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel_2.setBounds(82, 11, 123, 26);
		this.contentPane.add(this.lblNewLabel_2);
		
		this.lblError = new JLabel("");
		this.lblError.setForeground(Color.RED);
		this.lblError.setBounds(46, 133, 175, 15);
		this.contentPane.add(this.lblError);
		
		setVisible(true);
	}

	@Override
	public void addActionListener(ActionListener listener) {
		this.btnConfirmar.addActionListener(listener);
		this.btnConfirmar.setActionCommand(IVista.CONFIRMAR_MESA);
		this.btnCancelar.addActionListener(listener);
		this.btnCancelar.setActionCommand(IVista.CANCELAR_MESA);
	}

	public String getCantComensales() {
		return this.textFieldCantComensales.getText();
	}
	public String getEstado() {
		return (String) this.comboBoxEstados.getSelectedItem();
	}
	
	@Override
	public void cerrar() {
		setVisible(false);
	}
	
	public void setLblError(String msg) {
		this.lblError.setText(msg);
	}
}
