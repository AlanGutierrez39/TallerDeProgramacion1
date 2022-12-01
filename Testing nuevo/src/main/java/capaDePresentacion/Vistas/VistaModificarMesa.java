package capaDePresentacion.Vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import capaDeDatos.Mesa;
import enums.EstadosMesa;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;

public class VistaModificarMesa extends JFrame implements IVista{

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textFieldCantComensales;
	private JLabel lblNewLabel_2;
	private JComboBox comboBoxEstados;
	private JLabel lblError;
	private JButton btnCancelar;
	private JButton btnConfirmar;


	/**
	 * Create the frame.
	 */
	public VistaModificarMesa() {
		setTitle("Modificar mesa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 246, 243);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(null);
		
		this.lblNewLabel = new JLabel("Modificar mesa");
		this.lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.lblNewLabel.setBounds(48, 11, 123, 26);
		this.contentPane.add(this.lblNewLabel);
		
		this.lblNewLabel_1 = new JLabel("Cantidad comensales");
		this.lblNewLabel_1.setBounds(10, 64, 112, 14);
		this.contentPane.add(this.lblNewLabel_1);
		
		this.textFieldCantComensales = new JTextField();
		this.textFieldCantComensales.setColumns(10);
		this.textFieldCantComensales.setBounds(132, 61, 86, 20);
		this.contentPane.add(this.textFieldCantComensales);
		
		this.lblNewLabel_2 = new JLabel("Estado mesa");
		this.lblNewLabel_2.setBounds(10, 108, 86, 14);
		this.contentPane.add(this.lblNewLabel_2);
		
		this.comboBoxEstados = new JComboBox<String>();
		this.comboBoxEstados.setBounds(132, 104, 86, 20);
		this.contentPane.add(this.comboBoxEstados);
		this.comboBoxEstados.addItem((String) EstadosMesa.LIBRE.getEstado());
		this.comboBoxEstados.addItem((String) EstadosMesa.OCUPADA.getEstado());
		
		this.lblError = new JLabel("");
		this.lblError.setForeground(Color.RED);
		this.lblError.setBounds(31, 133, 175, 15);
		this.contentPane.add(this.lblError);
		
		this.btnCancelar = new JButton("Cancelar");
		this.btnCancelar.setBounds(23, 159, 89, 23);
		this.contentPane.add(this.btnCancelar);
		
		this.btnConfirmar = new JButton("Confirmar");
		this.btnConfirmar.setBounds(129, 159, 89, 23);
		this.contentPane.add(this.btnConfirmar);
		
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
	
	public void setCampos(Mesa mesa) {
		this.textFieldCantComensales.setText(String.valueOf(mesa.getCantComensales()));
	}
}